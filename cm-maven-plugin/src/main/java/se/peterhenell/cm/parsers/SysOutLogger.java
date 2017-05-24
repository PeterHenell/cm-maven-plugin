package se.peterhenell.cm.parsers;

import org.apache.maven.plugin.logging.Log;

public class SysOutLogger implements Log {

	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void debug(CharSequence content) {
		System.out.println(content);

	}

	@Override
	public void debug(CharSequence content, Throwable error) {
		System.out.println(content);

	}

	@Override
	public void debug(Throwable error) {
		System.out.println(error.getMessage());

	}

	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void info(CharSequence content) {
		System.out.println(content);

	}

	@Override
	public void info(CharSequence content, Throwable error) {
		System.out.println(content);

	}

	@Override
	public void info(Throwable error) {
		System.out.println(error.getMessage());

	}

	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void warn(CharSequence content) {
		System.out.println(content);

	}

	@Override
	public void warn(CharSequence content, Throwable error) {
		System.out.println(content);

	}

	@Override
	public void warn(Throwable error) {
		System.out.println(error.getMessage());

	}

	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void error(CharSequence content) {
		System.out.println(content);

	}

	@Override
	public void error(CharSequence content, Throwable error) {
		System.out.println(content);

	}

	@Override
	public void error(Throwable error) {
		System.out.println(error.getMessage());

	}
}
