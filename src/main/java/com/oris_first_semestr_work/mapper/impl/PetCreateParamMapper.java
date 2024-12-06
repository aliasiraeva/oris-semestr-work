package com.oris_first_semestr_work.mapper.impl;

import com.oris_first_semestr_work.entity.Pet;
import com.oris_first_semestr_work.mapper.ParamMapper;

public class PetCreateParamMapper implements ParamMapper<Pet> {
    @Override
    public Object[] mapParams(Object object) {
        Pet pet = (Pet) object;
        return new Object[] {pet.getId(), pet.getName(), pet.getType(), pet.getSubType()};
    }
}
