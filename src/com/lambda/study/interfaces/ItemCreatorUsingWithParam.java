package com.lambda.study.interfaces;

import com.lambda.study.entity.Item;

public interface ItemCreatorUsingWithParam {
	Item getItem(int id, String name);
}
