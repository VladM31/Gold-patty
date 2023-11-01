package com.vlad.nure.models.states

data class State<V>(
    val last : V,
    val current : V
){
    fun setCurrent(current: V) : State<V> {
        return State(
            last = this.current,
            current = current
        )
    }
}
