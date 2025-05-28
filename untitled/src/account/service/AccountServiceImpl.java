package account.service;

import account.entity.Account;
import account.repository.AccountRepository;
import account.repository.AccountRepositoryImpl;
import utility.KeyboardInput;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    private static AccountServiceImpl instance;

    private final AccountRepository accountRepository;

    private AccountServiceImpl() {
        this.accountRepository = AccountRepositoryImpl.getInstance();
    }

    public static AccountServiceImpl getInstance() {
        if (instance == null) {
            instance = new AccountServiceImpl();
        }
        return instance;
    }

    @Override
    public int register() {
        System.out.println("회원 가입을 진행합니다!");
        String userId = KeyboardInput.getStringInput("아이디를 입력하세요: ");
        String password = KeyboardInput.getStringInput("비밀번호를 입력하세요: ");

        Account account = new Account(userId, password);
        return accountRepository.save(account);
    }

    @Override
    public Integer signIn() {
        System.out.println("로그인을 진행합니다!");
        String userId = KeyboardInput.getStringInput("아이디를 입력하세요: ");
        Optional<Account> maybeAccount = accountRepository.findByUserId(userId);

        if (maybeAccount.isEmpty()) {
            System.out.println("존재하지 않는 사용자입니다.");
            return null;
        }

        String password = KeyboardInput.getStringInput("비밀번호를 입력하세요: ");
        Account account = maybeAccount.get();

        if (account.getPassword().equals(password)) {
            System.out.println("로그인 성공!");
            return (int) account.getId();
        }

        System.out.println("비밀번호가 일치하지 않습니다.");
        return null;
    }
}
