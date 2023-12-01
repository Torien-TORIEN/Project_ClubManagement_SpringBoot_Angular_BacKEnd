package tn.enicarthage.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Member;
import tn.enicarthage.Services.IMemberService;

@RestController
public class MemberController {
	
	@Autowired
	IMemberService memberService;
	
	@GetMapping("/members")
	@ResponseBody
	public List<Member> getAllMembers(){
		return memberService.getAllMember();
	}
	
	@GetMapping("/clubs/member/{cin}")
	@ResponseBody
	public List<Club> getClubsByMember(@PathVariable("cin") String cin) {
		return memberService.getAllClubsByMemberCin(cin);
	}
	
	@GetMapping("/members/name/{name}")
	@ResponseBody
	public List<Member> getMembersByName(@PathVariable("name") String name){
		return memberService.getMemberByName(name);
	}
	
	@GetMapping("/members/firstname/{fname}")
	@ResponseBody
	public List<Member> getMembersByFName(@PathVariable("fname") String fname){
		return memberService.getMemberByFirstname(fname);
	}
	
	@GetMapping("/members/{cin}")
	@ResponseBody
	public Member getMembersByCIN(@PathVariable("cin") String cin){
		return memberService.getMemberByCin(cin);
	}
	
	@PostMapping("/members")
	@ResponseBody
	public Member addMember(@RequestBody Member member) {
		return memberService.addMember(member);
	}
	
	@PutMapping("/members/{cin}")
	@ResponseBody
	public Member updateMember(@PathVariable("cin") String cin,@RequestBody Member member){
		member.setCIN(cin);
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("/members/{cin}")
	@ResponseBody
	public void deleteMember(@PathVariable("cin") String cin){
		 memberService.deleteMember(cin);
	}
	
	@PostMapping("/members/affectation-club/{cin}/{role}/{id}")
	@ResponseBody
	public void ajouterAuclub(@PathVariable("cin") String cin,@PathVariable("role") int idRole,@PathVariable("id") String idClub) {
		memberService.affecterMembreAuClub(cin, idRole, idClub);
	}
	
	@DeleteMapping("members/club/{cin}/{idClub}")
	@ResponseBody
	public void deleteMemberFromClub(@PathVariable("cin") String cin, @PathVariable("idClub") String idclub) {
		memberService.quitterClub(cin, idclub);
	}
	
}
