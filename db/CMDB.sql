   --WARNING THIS SCRIPT WILL DROP THE DMDB DATABASE.

USE master
GO
ALTER DATABASE CMDB SET SINGLE_USER
WITH ROLLBACK IMMEDIATE;
GO
DROP DATABASE CMDB
GO
CREATE DATABASE CMDB
GO
USE CMDB
GO


CREATE TABLE dbo.System(ID INT IDENTITY(1, 1) PRIMARY KEY, name VARCHAR(100) NOT NULL);
CREATE TABLE dbo.Server(ID INT IDENTITY(1, 1) PRIMARY KEY, URI VARCHAR(100) NOT NULL);
CREATE TABLE dbo.Environment(ID INT IDENTITY(1, 1) PRIMARY KEY, name VARCHAR(100) NOT NULL);
CREATE TABLE dbo.SystemServer(
    ID INT IDENTITY(1, 1) PRIMARY KEY,
    _system_ID INT NOT NULL CONSTRAINT [FK_SystemServer_System] FOREIGN KEY REFERENCES dbo.System(ID), 
    _server_ID INT NOT NULL CONSTRAINT [FK_SystemServer_Server] FOREIGN KEY REFERENCES dbo.Server(ID)
);
CREATE INDEX [IX_SystemServer_ServerSystem] ON dbo.SystemServer(_server_ID, _system_ID);

CREATE TABLE dbo.ServerEnvironment(
    ID INT IDENTITY(1, 1) PRIMARY KEY, 
    _server_ID INT NOT NULL CONSTRAINT [FK_ServerEnvironment_Server] FOREIGN KEY REFERENCES dbo.Server(ID), 
    _environment_ID INT NOT NULL CONSTRAINT [FK_ServerEnvironment_Environment] FOREIGN KEY REFERENCES dbo.Environment(ID)
);
CREATE INDEX [IX_ServerEnvironment_server_environment] ON dbo.ServerEnvironment(_server_ID, _environment_ID);

CREATE TABLE dbo.Package(
    ID INT IDENTITY(1, 1) PRIMARY KEY, 
    packageVersion VARCHAR(100) NOT NULL CONSTRAINT [UNQ_PackageVersion] UNIQUE,
    packageStatus VARCHAR(20),
    _system_ID INT NOT NULL CONSTRAINT [FK_Package_System] FOREIGN KEY REFERENCES dbo.System(ID),
    buildDate DATETIME2(2) NOT NULL CONSTRAINT [DEF_Package_buildDate] DEFAULT(SYSDATETIME()),
    originatingBranch VARCHAR(20) NOT NULL,
    featureBranch VARCHAR(20),
);
CREATE INDEX [IX_Package_system] ON dbo.Package(_system_ID);

CREATE TABLE dbo.PackageComparison(
    ID INT IDENTITY(1, 1) PRIMARY KEY, 
    _package_ID INT NOT NULL CONSTRAINT [FK_PackageComparison_Package] FOREIGN KEY REFERENCES dbo.Package(ID), 
    _comparedToServer_ID INT NOT NULL CONSTRAINT [FK_PackageComparison_Server] FOREIGN KEY REFERENCES dbo.Server(ID),
    _comparedToPackage_ID INT NOT NULL CONSTRAINT [FK_PackageComparison_ComparedToPackage] FOREIGN KEY REFERENCES dbo.Package(ID)
);
CREATE INDEX [IX_PackageComparison_package_ID] ON dbo.PackageComparison(_package_ID);
CREATE INDEX [IX_PackageComparison_comparedToServer_ID] ON dbo.PackageComparison(_comparedToServer_ID);
CREATE INDEX [IX_PackageComparison_comparedToPackage_ID] ON dbo.PackageComparison(_comparedToPackage_ID);

CREATE TABLE dbo.PackageComparisonDetails(
    ID INT IDENTITY(1, 1) PRIMARY KEY, 
    _packageComparison_ID INT NOT NULL FOREIGN KEY REFERENCES dbo.PackageComparison(ID),
    commitMessage VARCHAR(max) NOT NULL,
    commitIdentifier VARCHAR(20) NOT NULL,
    committedAt VARCHAR(400) NOT NULL,
    committedBy VARCHAR(100) NOT NULL,
    jiraNumber VARCHAR(50) NOT NULL,
    jiraSummary VARCHAR(max),
    serviceNowID VARCHAR(100)
);
CREATE INDEX [IX_PackageComparisonDetails_packageComparison_ID] ON dbo.PackageComparisonDetails(_packageComparison_ID);
CREATE INDEX [IX_PackageComparisonDetails_commitIdentifier] ON dbo.PackageComparisonDetails(commitIdentifier);


CREATE TABLE dbo.Deploy(
    ID INT IDENTITY(1, 1) PRIMARY KEY, 
    _package_ID INT NOT NULL CONSTRAINT [FK_Deploy_Package] FOREIGN KEY REFERENCES dbo.Package(ID), 
    _server_ID INT NOT NULL CONSTRAINT [FK_Deploy_Server] FOREIGN KEY REFERENCES dbo.Server(ID),
    deployedAt datetime2(2) NOT NULL,
    deployedBy VARCHAR(100) NOT NULL,
    triggeredOnHostName VARCHAR(100),
    triggeredFromPath VARCHAR(100),
    databaseUsername VARCHAR(100),
);
CREATE INDEX [IX_Deploy_package_ID] ON dbo.Deploy(_package_ID);
CREATE INDEX [IX_Deploy_server_ID] ON dbo.Deploy(_server_ID);

SET IDENTITY_INSERT dbo.System ON;
INSERT dbo.System (ID, name )
EXEC(' 
  SELECT 6, ''CRM''
  SELECT 1, ''HRM''
  SELECT 2, ''GL''
  SELECT 5, ''A''
  SELECT 3, ''B''
  SELECT 4, ''C''');
SET IDENTITY_INSERT dbo.System OFF;

SET IDENTITY_INSERT dbo.Environment ON;
INSERT dbo.Environment ([ID],name )
EXEC(' 
  SELECT 2, ''A'' 
  SELECT 4, ''B''
  SELECT 5, ''C''
  SELECT 3, ''D''
  SELECT 1, ''E''
  SELECT 6, ''F''');
SET IDENTITY_INSERT dbo.Environment OFF;




SET IDENTITY_INSERT dbo.Server ON ;
INSERT dbo.Server ( ID, URI )
EXEC(' 
  SELECT 1, ''LOCALHOST''
');
SET IDENTITY_INSERT dbo.Server OFF;

