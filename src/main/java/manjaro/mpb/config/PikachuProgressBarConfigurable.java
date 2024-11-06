package manjaro.mpb.config;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PikachuProgressBarConfigurable implements Configurable {

  private PikachuProgressBarSettingsComponent mySettingsComponent;

  // A default constructor with no arguments is required because this implementation
  // is registered as an applicationConfigurable EP

  @Nls(capitalization = Nls.Capitalization.Title)
  @Override
  public String getDisplayName() {
    return "Pika-Progress Bar";
  }

  @Override
  public JComponent getPreferredFocusedComponent() {
    return mySettingsComponent.getPreferredFocusedComponent();
  }

  @Nullable
  @Override
  public JComponent createComponent() {
    mySettingsComponent = new PikachuProgressBarSettingsComponent();
    return mySettingsComponent.getPanel();
  }

  @Override
  public boolean isModified() {
    PikachuProgressBarSettingsState settings = PikachuProgressBarSettingsState.getInstance();
    boolean modified = !mySettingsComponent.getChosenCharacter().equals(settings.selectedCharacter);
    modified |= mySettingsComponent.getChosenCharacter() != settings.selectedCharacter;
    return modified;
  }

  @Override
  public void apply() {
    PikachuProgressBarSettingsState settings = PikachuProgressBarSettingsState.getInstance();
    settings.selectedCharacter = mySettingsComponent.getChosenCharacter();
  }

  @Override
  public void reset() {
    PikachuProgressBarSettingsState settings = PikachuProgressBarSettingsState.getInstance();
    mySettingsComponent.setChosenCharacter(settings.selectedCharacter);
  }

  @Override
  public void disposeUIResources() {
    mySettingsComponent = null;
  }

}