package de.pkrause.springit.controller;

import java.util.Optional;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.pkrause.springit.model.Link;
import de.pkrause.springit.model.Vote;
import de.pkrause.springit.repository.LinkRepository;
import de.pkrause.springit.repository.VoteRepository;

@RestController
public class VoteController {

    private VoteRepository voteRepository;
    private LinkRepository linkRepository;

    public VoteController(VoteRepository voteRepository, LinkRepository linkRepository) {
        this.voteRepository = voteRepository;
        this.linkRepository = linkRepository;
    }

    // http://localhost:8080/vote/link/1/direction/-1/votecount/5
    @GetMapping("/vote/link/{linkID}/direction/{direction}/votecount/{voteCount}")
    // @Secured({"ROLE_USER"})
    public int vote(@PathVariable Long linkID, @PathVariable short direction, @PathVariable int voteCount) {
        Optional<Link> optionalLink = linkRepository.findById(linkID);
        if (optionalLink.isPresent()) {
            Link link = optionalLink.get();
            Vote vote = new Vote(direction, link);
            voteRepository.save(vote);

            link.addVote(vote);
            linkRepository.save(link);
            int updatedVoteCount = link.getVoteCount();

            return updatedVoteCount;

        }
        return voteCount;
    }

}
