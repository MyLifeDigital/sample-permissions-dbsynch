package io.consentric.connector.client.converter;

import io.consentric.connector.client.permissionsService.ChangeDTO;
import io.consentric.connector.client.permissionsService.TransactionDTO;
import io.consentric.connector.client.permissionsService.TransactionsDTO;
import io.consentric.connector.service.model.CitizenConsentStatus;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CitizenConsentConverter {

    private CitizenConsentConverter() {

    }

    public static List<CitizenConsentStatus> fromTransactionList(TransactionsDTO transactionsDTO) {
        return transactionsDTO.getTransactions()
            .stream()
            .flatMap(CitizenConsentConverter::getAndConvertChanges)
            .collect(Collectors.toList());
    }

    private static Stream<CitizenConsentStatus> getAndConvertChanges(TransactionDTO transactionDTO) {
        return transactionDTO.getChanges()
            .stream()
            .map(change -> convertToModel(
                transactionDTO.getCitizenId(),
                transactionDTO.getExternalRef(),
                change));
    }

    private static CitizenConsentStatus convertToModel(String citizenId, String externalRef, ChangeDTO changeDTO) {
        return new CitizenConsentStatus()
            .withCitizenId(citizenId)
            .withExternalRef(externalRef)
            .withOptionId(changeDTO.getOptionId())
            .withState(changeDTO.getState())
            .withObtainedAt(changeDTO.getObtainedAt())
            .withValidUntil(changeDTO.getValidUntil());
    }
}
