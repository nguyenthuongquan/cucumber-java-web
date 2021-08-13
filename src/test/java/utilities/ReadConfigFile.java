package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({
        "classpath:config.properties",
        "classpath:cucumber.properties",
        "classpath:environment.properties",
})
public interface ReadConfigFile extends Config {

    /*** File config.properties */
    @Config.Key("takeScreenshotForEveryStep")
    Boolean isScreenshotTakenForEveryStep();

    @Config.Key("takeScreenshotForVerificationStep")
    Boolean isScreenshotTakenForVerificationStep();

    @Config.Key("takeScreenshotWhenScenarioFails")
    Boolean isScreenshotTakenWhenScenarioFails();

    @Config.Key("browserHeadless")
    Boolean isBrowserHeadless();

    /*** File cucumber.properties */
    @Config.Key("cucumber.publish.enabled")
    Boolean isCucumberPublishEnabled();

    /*** File environment.properties */
    @Config.Key("Browser")
    String browser();

    @Config.Key("Environment")
    String environment();

    @Config.Key("App")
    String appName();

    @Config.Key("Build.Version")
    String buildVersion();
}