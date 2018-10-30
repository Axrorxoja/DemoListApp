package com.example.axrorxoja.demolistapp.entity.global

import com.example.axrorxoja.demolistapp.common.ErrorObject


class BaseData<T>(
    val success: T? = null,
    val error: ErrorObject? = null
)