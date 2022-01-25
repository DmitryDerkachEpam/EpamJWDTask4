package com.epam.textComponents;

import java.util.List;

public interface Component {
	List<Component> getTextParts();
    String getValue();
}
