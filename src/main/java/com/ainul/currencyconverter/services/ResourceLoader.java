package com.ainul.currencyconverter.services;

import java.io.IOException;
import java.net.URL;

/**
 * Utility class for loading application resources.
 */
public final class ResourceLoader {
    /**
     * Prevents instantiation of this utility class.
     */
    private ResourceLoader() {}

    /**
     * Ensures the resource identifier is present before path formatting.
     *
     * @param resourceId the resource identifier or filename
     * @return the validated resource identifier
     * @throws NullPointerException if the resource identifier is null or blank
     */
    private static String requireResourceId(String resourceId) {
        if (resourceId == null || resourceId.isBlank()) {
            throw new NullPointerException("Resource identifier cannot be null or blank.");
        }

        return resourceId;
    }

    /**
     * Returns an absolute classpath path for an application resource.
     *
     * @param path the relative or absolute path to the resource
     * @return the absolute path to the resource
     * @throws NullPointerException if the provided path is null or blank
     */
    public static String getAbsolutePath(String path) {
        var validatedPath = requireResourceId(path);

        if (validatedPath.startsWith("/")) {
            return validatedPath;
        }

        return "/" + "com/ainul/currencyconverter" + "/" + validatedPath;
    }

    /**
     * Resolves a classpath resource to a URL.
     *
     * @param absolutePath the absolute classpath path to the resource
     * @return the resolved resource URL
     * @throws IOException if the resource cannot be found at the given absolute path
     */
    private static URL resolveResource(String absolutePath) throws IOException {
        var resource = ResourceLoader.class.getResource(absolutePath);

        if (resource == null) {
            throw new IOException("Resource not found at: " + absolutePath
                    + ". Ensure the file exists in src/main/resources" + absolutePath + ".");
        }

        return resource;
    }

    /**
     * Returns the URL of a classpath resource.
     *
     * @param path the name of the resource
     * @return the URL of the resource
     * @throws IOException if the resource cannot be found for the resolved path or if the provided
     *         path is null or blank
     */
    public static URL getResource(String path) throws IOException {
        return resolveResource(getAbsolutePath(path));
    }

    /**
     * Resolves a resource to an external URL string.
     *
     * @param path the name of the resource
     * @return the external form of the resource path
     * @throws IOException if the resource cannot be found or if the provided path is null or blank
     */
    public static String getResourcePath(String path) throws IOException {
        return resolveResource(getAbsolutePath(path)).toExternalForm();
    }

    /**
     * Builds a relative FXML path for the given FXML identifier.
     *
     * @param fxml the FXML identifier or filename
     * @return the relative path to the FXML resource
     * @throws NullPointerException if the FXML identifier is null or blank
     */
    public static String resolveFxmlPath(String fxml) {
        String validatedFxmlId = requireResourceId(fxml);
        String filename =
                validatedFxmlId.endsWith(".fxml") ? validatedFxmlId : validatedFxmlId + ".fxml";
        return "pages" + "/" + filename;
    }

    /**
     * Builds an absolute FXML path for the given FXML identifier.
     *
     * @param fxml the FXML identifier or filename
     * @return the absolute path to the FXML resource
     * @throws IOException if the FXML identifier is null or blank
     */
    public static String getFxmlPathAbsolute(String fxml) {
        return ResourceLoader.getAbsolutePath(resolveFxmlPath(fxml));
    }

    /**
     * Resolves an FXML resource path to a URL.
     *
     * @param fxml the name of the FXML resource
     * @return the URL of the FXML resource
     * @throws IOException if the FXML identifier is null or blank, or if the resource cannot be
     *         found
     */
    public static URL getFxml(String fxml) throws IOException {
        return ResourceLoader.getResource(resolveFxmlPath(fxml));
    }
}
