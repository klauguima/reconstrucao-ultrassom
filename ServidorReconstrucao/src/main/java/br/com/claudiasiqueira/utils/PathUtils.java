package br.com.claudiasiqueira.utils;

public class PathUtils {
	public static String getResourcePath(String resourceName) {
		String reconstrucaoPath = PathUtils.class
                .getClassLoader().getResource(resourceName).getPath();
		return reconstrucaoPath.substring(1);
	}
}
