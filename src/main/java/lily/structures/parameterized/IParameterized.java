package lily.structures.parameterized;

import lily.structures.GeneratorSettings;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static lily.structures.GeneratorSettings.SettingConstants.*;

public class IParameterized {

    String prefix = DEFAULT_PREFIX;
    String seperator = DEFAULT_SEPERATOR;
    String suffix = DEFAULT_SUFFIX;

    public IParameterized() {
        try {
            prefix = (String) GeneratorSettings.SettingConstants.class.getDeclaredField(this.getClass().getSimpleName().toUpperCase() + "_PREFIX").get(null);
            seperator = (String) GeneratorSettings.SettingConstants.class.getDeclaredField(this.getClass().getSimpleName().toUpperCase() + "_SEPERATOR").get(null);
            suffix = (String) GeneratorSettings.SettingConstants.class.getDeclaredField(this.getClass().getSimpleName().toUpperCase() + "_SUFFIX").get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return toString(new ArrayList<>());
    }

    public String toString(ArrayList<String> parameters) {
        StringBuilder totalString = new StringBuilder();

        // Invoke all local non-null variables with their getter function
        if (parameters.isEmpty()) {
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                String parameter = (String) field.get(this);

                if (parameter != null) {
                    String getInvokedParameter = (String) this.getClass().getMethod("get" + StringUtils.capitalize(field.getName())).invoke(this);
                    parameters.add((getInvokedParameter));
                }

            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } }

        if (!parameters.isEmpty()) {
            boolean firstRun = true;
            totalString.append(prefix);

            for (String parameter : parameters) {

                if (parameter != null) {
                    // Add seperator on subsequent strings
                    if (!firstRun) {
                        totalString.append(seperator);
                    } else {
                        firstRun = false;
                    }
                    totalString.append(parameter);
                }
            }
            totalString.append(suffix);
        }

        return totalString.toString();
    }
}
