package org.orgin.factory;

import org.orgin.bean.YamlBean;
import org.orgin.constant.ConfigConstant;
import org.orgin.utils.YamlUtil;

public final class ConfigFactory {

    private static final YamlBean YAML_BEAN = YamlUtil.getYamlBeanWithRelativePath(ConfigConstant.CONFIG_FILE, YamlBean.class);

    public static String getAppBasePackage() {
        return YAML_BEAN.getBasePackage();
    }
}
