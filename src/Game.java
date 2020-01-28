import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Game {
    public static int jailposition = 30;
    public static int startSquareMoney = 2000000;
    ArrayList<Square> board = new ArrayList<>();
    private ArrayList<Person> players;
    private Board gameBoard;
    private int cycle = 0;
    private int turn = 0;

    public Game() {
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    void move(Person person, int moveStep) {
        person.setLastDice(moveStep);
        int currentPosition = person.getPosition();
        board.get(currentPosition).playersOnTheSquare.remove(person);
        currentPosition += moveStep;
        if (currentPosition >= gameBoard.getGameboard().size()) {
            currentPosition -= gameBoard.getGameboard().size();
            person.setCurrentBalance(person.getCurrentBalance() + startSquareMoney);//başlangıçtan geçtiyse para veriyoruz
            System.out.println(person.getName() + " passed from start square and get " + startSquareMoney);
        }
        person.setPosition(currentPosition);
        board.get(currentPosition).playersOnTheSquare.add(person);
    }

    public ArrayList<Person> getPlayers() {
        return players;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    void setGame() throws IOException {
        //İmport the config.properties file for configuration on simulation
        InputStream inputStream = new FileInputStream("config.properties");
        InputStream inputStream2 = new FileInputStream("cities_rent.properties");
        FileInputStream inputStream3 = new FileInputStream("cities_price.properties");
        Properties config = new Properties();
        Properties cityRentConfig = new Properties();
        Properties boardConfig = new Properties();
        config.load(inputStream);
        cityRentConfig.load(inputStream2);
        boardConfig.load(inputStream3);

        //initialization of board
        board.add(new StartingSquare());
        board.add(new LandSquare("sisli", Integer.parseInt(boardConfig.getProperty("sisli")), Integer.parseInt(cityRentConfig.getProperty("sisli")), 1));
        board.add(new Square("DrawCard"));
        board.add(new LandSquare("mecidiyekoy", Integer.parseInt(boardConfig.getProperty("mecidiyekoy")), Integer.parseInt(cityRentConfig.getProperty("mecidiyekoy")), 1));
        board.add(new TaxSquare(Integer.parseInt(config.getProperty("tax"))));
        board.add(new TransportationSquare("tram", Integer.parseInt(boardConfig.getProperty("tram"))));
        board.add(new LandSquare("anadoluHisari", Integer.parseInt(boardConfig.getProperty("anadoluHisari")), Integer.parseInt(cityRentConfig.getProperty("anadoluHisari")), 2));
        board.add(new Square("DrawCard"));
        board.add(new LandSquare("beylerbeyi", Integer.parseInt(boardConfig.getProperty("beylerbeyi")), Integer.parseInt(cityRentConfig.getProperty("beylerbeyi")), 2));
        board.add(new LandSquare("uskudar", Integer.parseInt(boardConfig.getProperty("uskudar")), Integer.parseInt(cityRentConfig.getProperty("uskudar")), 2));
        board.add(new Square("jailVisitor"));
        board.add(new LandSquare("ortakoy", Integer.parseInt(boardConfig.getProperty("ortakoy")), Integer.parseInt(cityRentConfig.getProperty("ortakoy")), 3));
        board.add(new PublicCorporationSquare("telecommunication", Integer.parseInt(boardConfig.getProperty("telecommunication")), Integer.parseInt(cityRentConfig.getProperty("telecommunication"))));
        board.add(new LandSquare("besiktas", Integer.parseInt(boardConfig.getProperty("besiktas")), Integer.parseInt(cityRentConfig.getProperty("besiktas")), 3));
        board.add(new LandSquare("taksim", Integer.parseInt(boardConfig.getProperty("taksim")), Integer.parseInt(cityRentConfig.getProperty("taksim")), 3));
        board.add(new TransportationSquare("plane", Integer.parseInt(boardConfig.getProperty("plane"))));
        board.add(new LandSquare("atakoy", Integer.parseInt(boardConfig.getProperty("atakoy")), Integer.parseInt(cityRentConfig.getProperty("atakoy")), 4));
        board.add(new Square("DrawCard"));
        board.add(new LandSquare("yesilKoy", Integer.parseInt(boardConfig.getProperty("yesilKoy")), Integer.parseInt(cityRentConfig.getProperty("yesilKoy")), 4));
        board.add(new LandSquare("bahcesehir", Integer.parseInt(boardConfig.getProperty("bahcesehir")), Integer.parseInt(cityRentConfig.getProperty("bahcesehir")), 4));
        board.add(new Square("freeParking"));
        board.add(new LandSquare("atasehir", Integer.parseInt(boardConfig.getProperty("atasehir")), Integer.parseInt(cityRentConfig.getProperty("atasehir")), 5));
        board.add(new Square("DrawCard"));
        board.add(new LandSquare("bostanciSahilYolu", Integer.parseInt(boardConfig.getProperty("bostanciSahilYolu")), Integer.parseInt(cityRentConfig.getProperty("bostanciSahilYolu")), 5));
        board.add(new LandSquare("bagdatCaddesi", Integer.parseInt(boardConfig.getProperty("bagdatCaddesi")), Integer.parseInt(cityRentConfig.getProperty("bagdatCaddesi")), 5));
        board.add(new TransportationSquare("ship", Integer.parseInt(boardConfig.getProperty("ship"))));
        board.add(new LandSquare("tesvikiye", Integer.parseInt(boardConfig.getProperty("tesvikiye")), Integer.parseInt(cityRentConfig.getProperty("tesvikiye")), 6));
        board.add(new LandSquare("nisantasi", Integer.parseInt(boardConfig.getProperty("nisantasi")), Integer.parseInt(cityRentConfig.getProperty("nisantasi")), 6));
        board.add(new PublicCorporationSquare("fuelGass", Integer.parseInt(boardConfig.getProperty("fuelGass")), Integer.parseInt(cityRentConfig.getProperty("fuelGass"))));
        board.add(new LandSquare("macka", Integer.parseInt(boardConfig.getProperty("macka")), Integer.parseInt(cityRentConfig.getProperty("macka")), 6));
        board.add(new Jail(Integer.parseInt(config.getProperty("exitPrice"))));
        board.add(new LandSquare("emirgan", Integer.parseInt(boardConfig.getProperty("emirgan")), Integer.parseInt(cityRentConfig.getProperty("emirgan")), 7));
        board.add(new LandSquare("bebek", Integer.parseInt(boardConfig.getProperty("bebek")), Integer.parseInt(cityRentConfig.getProperty("bebek")), 7));
        board.add(new Square("DrawCard"));
        board.add(new LandSquare("yenikoy", Integer.parseInt(boardConfig.getProperty("yenikoy")), Integer.parseInt(cityRentConfig.getProperty("yenikoy")), 7));
        board.add(new TransportationSquare("metro", Integer.parseInt(boardConfig.getProperty("metro"))));
        board.add(new Square("DrawCard"));
        board.add(new LandSquare("levent", Integer.parseInt(boardConfig.getProperty("levent")), Integer.parseInt(cityRentConfig.getProperty("levent")), 8));
        board.add(new TaxSquare(Integer.parseInt(config.getProperty("luxury_tax"))));
        board.add(new LandSquare("etiler", Integer.parseInt(boardConfig.getProperty("etiler")), Integer.parseInt(cityRentConfig.getProperty("etiler")), 8));

        this.gameBoard = new Board(board); //set game board

        //take player number and player's starting balance and create players with Person types
        int playerNumber = Integer.parseInt((String) config.get("players"));
        int startingBalance = Integer.parseInt((String) config.get("starting_money"));
        ArrayList<Person> playerList = new ArrayList<>();
        for (int i = 0; i < playerNumber; i++) {
            String name = "player".concat(String.valueOf(i));
            playerList.add(new Person(name, startingBalance));
        }
        this.players = playerList; //set player list

        for (int i = 0; i < players.size(); i++) {
            board.get(0).playersOnTheSquare.add(players.get(i));
        }
    }


    //if players currentBalance less than or equal 0 , player was bankrupt.
    boolean isBankrupt(Person person) {
        if (person.getCurrentBalance() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    //if person in reward square , takes money or if person in tax square , he/she gives money
    void updateStatus(Person person) {
        Square currentPosition = (this.gameBoard).getGameboard().get(person.getPosition()); // current square
        if (currentPosition instanceof TaxSquare) { // pay tax
            person.setCurrentBalance(person.getCurrentBalance() - ((TaxSquare) board.get(person.getPosition())).getTaxAmount());
        } else if (currentPosition instanceof Jail) { // enter jail
            person.enterJail();
        } else if (currentPosition.type.equals("DrawCard")) { // draw card
            int cardId = (int) (Math.random() * 9);
            Cards cards = new Cards();
            cards.applyCardsEffect(cardId, person, this);
        } else if (currentPosition instanceof Property) {
            if (((Property) currentPosition).owner == null) { //sahipsiz bir yeri satın alma
                if (((Property) currentPosition).price < person.getCurrentBalance()) { //yeterli para varsa
                    double probability = Math.random();
                    if (currentPosition instanceof LandSquare) {
//                        System.out.println("error class " + currentPosition.getClass());
                        if (person.hasColor(((LandSquare) currentPosition).getColourID())) {
                            ((LandSquare) currentPosition).buy(person);
                        } else if (probability < 0.7) {
                            ((LandSquare) currentPosition).buy(person);
                        }
                    } else if (probability < 0.7) {
                        ((Property) currentPosition).buy(person);
                    }
                }
            } else if (!((Property) currentPosition).owner.equals(person)) { // kira ödeme
                Person renter = person;
                Person owner = ((Property) currentPosition).owner;
                ((Property) currentPosition).rent(owner, renter);
            }
        }
        buyHouseAttempt(person);
    }

    //if there are 1 players left, the game is over.
    boolean isGameOver() {
        if (players.size() < 2) {
            return true;
        } else {
            return false;
        }
    }

    void beforeRollingDices(Person person) {
        System.out.println("\n" + person.getName());
        System.out.println("Turn: " + getTurn() + "\n" + "Cycle: " + getCycle());
        System.out.println(person.getName() + " is located now " + person.getPosition() + "th in square");
        System.out.println(person.getName() + " current balance " + person.getCurrentBalance());
        System.out.println("Type of the square: " + gameBoard.getGameboard().get(person.getPosition()).getType());
    }

    void afterRollingDices(Person person, int[] dices) {
        System.out.println("\nFirst Dice = " + dices[0] + "\nSecond Dice = " + dices[1] + "\nSum of Dices = " + dices[2]);
        System.out.println(person.getName() + " is located now " + person.getPosition() + "th in square");
        System.out.println("Type of the square: " + gameBoard.getGameboard().get(person.getPosition()).getType());
        if ((this.gameBoard).getGameboard().get(person.getPosition()) instanceof TaxSquare)
            System.out.println("Tax Price is: " + ((TaxSquare) (this.gameBoard).getGameboard().get(person.getPosition())).getTaxAmount());
        System.out.println(person.getName() + " current balance is: " + person.getCurrentBalance());
    }

    void afterCycle(ArrayList<Person> players) {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Name: " + players.get(i).getName());
            System.out.println("Location: " + players.get(i).getPosition());
            System.out.println("Current Balance: " + players.get(i).getCurrentBalance() + "\n");

        }
    }

    void buyHouseAttempt(Person person) {
        for (int i = 0; i < person.getOwnSquares().size(); i++) {
            if (person.getOwnSquares().get(i) instanceof LandSquare) {
                boolean canBuy = true;
                for (int j = 0; j < this.board.size(); j++) {
                    if (this.board.get(j) instanceof LandSquare) { // mülk mü
                        if (((LandSquare) this.board.get(j)).getColourID() == ((LandSquare) person.getOwnSquares().get(i)).getColourID()) { //
                            if (((LandSquare) this.board.get(j)).owner == null) {
                                canBuy = false;
                                break;
                            }
                            if (!((LandSquare) this.board.get(j)).owner.equals(person)) {
                                canBuy = false;
                                break;
                            }
                        }
                    }
                }
                if (canBuy && (person.getCurrentBalance() >= ((LandSquare) person.getOwnSquares().get(i)).getCostOfHouse())
                        && (((LandSquare) person.getOwnSquares().get(i)).getNumberOfHotel() != 1)) { // satın alabiyiorsa, parası varsa, 1 oteli yoksa
                    if (((LandSquare) person.getOwnSquares().get(i)).getNumberOfHouse() == 4) { //otel
                        if ((person.getCurrentBalance() >= ((LandSquare) person.getOwnSquares().get(i)).getCostOfHotel())) {
                            ((LandSquare) person.getOwnSquares().get(i)).changeHousesWithHotels(person);
                        }
                    } else {
                        ((LandSquare) person.getOwnSquares().get(i)).buildHouse(person); // build house
                    }
                }
            }
        }
    }
}

