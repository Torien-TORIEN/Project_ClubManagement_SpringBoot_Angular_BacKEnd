package tn.enicarthage.Services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Member;
import tn.enicarthage.Repositories.MemberRepository;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	MemberRepository memberRepository;


	@Override
	public Member addMember(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.save(member);
	}

	@Override
	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public void deleteMember(String cin) {
		 memberRepository.deleteById(cin);
	}

	@Override
	public Member getMemberByCin(String cin) {
		return memberRepository.findById(cin).orElse(null);
	}

	@Override
	public Member getMemberByNameAndFirstname(String name, String firstname) {
		return memberRepository.getMemberByNameAndFirtsName(name,firstname);
	}

	@Override
	public Member getMemberByEmail(String email) {
		return memberRepository.getMemberByEmail(email);
	}

	@Override
	public List<Member> getAllMember() {
		return (List<Member>) memberRepository.findAll();
	}

	@Override
	public List<Member> getMemberByName(String name) {
		return memberRepository.getAllMembersByName(name);
	}

	@Override
	public List<Member> getMemberByFirstname(String firstname) {
		return memberRepository.getAllMembersByFistName(firstname);
	}

	@Override
	public List<Club> getAllClubsByMemberCin(String cin) {
		return memberRepository.getClubsByMemberCin(cin);
	}

	@Override
	@Transactional
	public void quitterClub(String cin,String clubId) {
		memberRepository.deleteClubMemberByCin(cin,clubId);
		
	}

	@Override
	@Transactional
	public void affecterMembreAuClub(String cin, int role, String Club) {
		memberRepository.affecterMemberAuClub(cin, role,Club);
	} 


}
