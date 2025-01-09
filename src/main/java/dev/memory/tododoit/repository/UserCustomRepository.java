package dev.memory.tododoit.repository;

public interface UserCustomRepository  {

    Boolean existsNotDeletedByAccountId(String accountId);

    Boolean existsNotDeletedByEmail(String email);
}
