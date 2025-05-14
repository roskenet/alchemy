package de.roskenet.poker;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PokerService
{
    @Value("${iterations:200000}")
    private long maxIterations;

    public static void main( String[] args ) {
        SpringApplication.run(PokerService.class, args);
    }

    @GetMapping("/poker")
    public PokerResponse getSomething(@RequestParam(value="board", required = false) String board, @RequestParam("hands") List<String> hands)
            throws Exception {
//        var response = new PokerResponse();
//        response.setBoard(board);
//        response.setHand(hand);
//        return response;
//        String[] input = new String[] {"-b", board};

        var arrayList = new ArrayList<String>();
        if(board != null && board != "") {
            arrayList.add("-b");
            arrayList.add(board);
        }
//        String[] s = hands.split(" ");

        for (String str: hands) {
            arrayList.add(str);
        }

//        String[] retList = arrayList.toArray()

        return Console.calculateOdd(arrayList.toArray(new String[arrayList.size()]), maxIterations);
    }
}
