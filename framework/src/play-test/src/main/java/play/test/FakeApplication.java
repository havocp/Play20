package play.test;

import java.io.*;
import java.util.*;

import play.GlobalSettings;

import play.libs.*;

/**
 * A Fake application.
 */
public class FakeApplication {
    
    final play.api.test.FakeApplication wrappedApplication;
    
    /**
     * A Fake application.
     *
     * @param path The application path
     * @param classloader The application classloader
     * @param additionalConfiguration Additional configuration
     * @param additionalPlugins Additional plugins
     */
    public FakeApplication(File path, ClassLoader classloader, Map<String,String> additionalConfiguration, List<String> additionalPlugins) {
        this(path, classloader, additionalConfiguration, additionalPlugins, null);
    }

    /**
     * A Fake application.
     *
     * @param path The application path
     * @param classloader The application classloader
     * @param additionalConfiguration Additional configuration
     * @param additionalPlugins Additional plugins
     * @param forceGlobal global settings to use, overriding the defaults
     */
    public FakeApplication(File path, ClassLoader classloader, Map<String,String> additionalConfiguration, List<String> additionalPlugins, GlobalSettings forceGlobal) {
        wrappedApplication = new play.api.test.FakeApplication(
            path, 
            classloader, 
            Scala.toSeq(additionalPlugins), 
            Scala.<String>emptySeq(), 
            Scala.asScala(additionalConfiguration),
            Scala.<play.api.GlobalSettings>Option(forceGlobal != null ? new play.core.j.JavaGlobalSettingsAdapter(forceGlobal) : null)
        );
    }

    public play.api.test.FakeApplication getWrappedApplication() {
        return wrappedApplication;
    }
    
}