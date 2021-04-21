package by.gomel.noyvik.library.controller.attribute;

import javax.servlet.http.HttpServletRequest;

import static by.gomel.noyvik.library.controller.constant.CommandConstant.ATTRIBUTE_SETTER_PATH;

public class AttributeSetterFactory {

    private static final AttributeSetterFactory INSTANCE = new AttributeSetterFactory();

    private AttributeSetterFactory() {
    }

    public static AttributeSetterFactory getInstance() {
        return INSTANCE;
    }

    public void getAttributeSetter(String target, HttpServletRequest request) {
        try {

            String classTarget = firstCharToUpperCase(target);
            Class type = Class.forName(String.format(ATTRIBUTE_SETTER_PATH, classTarget));
            AttributeSetter attributeSetter = (AttributeSetter) type.asSubclass(AttributeSetter.class).newInstance();
            attributeSetter.setAttribute(request);
        } catch (Exception e){
            new EmptyAttributeSetter().setAttribute(request);
        }

    }

    public String firstCharToUpperCase(String target) {
            return target.substring(0, 1).toUpperCase() + target.substring(1);

    }
}
