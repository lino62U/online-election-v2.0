import { Candidate } from "../interfaces/candidate.interface";
import axios from "../../../config/axios";

export const fetchCandidates = async (): Promise<Candidate[]> => {
  try {
    const response = await axios.get("/auth/all-candidate");
    const candidates: Candidate[] = response.data;
    return candidates;
  } catch (error) {
    
    return [];
  }
};
