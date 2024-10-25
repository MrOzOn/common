package com.mrozon.common.core

interface UseCaseWithoutInput<out Output> {
    operator fun invoke(): Output
}

interface SuspendUseCaseWithoutInput<out Output> {
    suspend operator fun invoke(): Output
}

interface UseCase<in Param, out Output> {
    operator fun invoke(param: Param): Output
}

interface SuspendUseCase<in Param, out Output> {
    suspend operator fun invoke(param: Param): Output
}