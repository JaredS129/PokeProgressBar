package manjaro.mpb.config;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import manjaro.mpb.MBCharacter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static manjaro.mpb.MBCharacter.PIKACHU;


@State(
        name = "manjaro.mpb.config.MarioProgressBarSettingsState",
        storages = @Storage("MarioProgressBarPluginSettings.xml")
)
public class PikachuProgressBarSettingsState implements PersistentStateComponent<PikachuProgressBarSettingsState> {

  public MBCharacter selectedCharacter = PIKACHU;

  public static PikachuProgressBarSettingsState getInstance() {
    return ApplicationManager.getApplication().getService(PikachuProgressBarSettingsState.class);
  }

  @Nullable
  @Override
  public PikachuProgressBarSettingsState getState() {
    return this;
  }

  @Override
  public void loadState(@NotNull PikachuProgressBarSettingsState state) {
    XmlSerializerUtil.copyBean(state, this);
  }

}