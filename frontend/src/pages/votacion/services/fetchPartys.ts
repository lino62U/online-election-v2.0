import { EmptyParty, Party } from "../interfaces/party.interface";
import axios from "../../../config/axios";

export const fetchPartys = async (): Promise<Party[]> => {
  try {
    const response = await axios.get("/api/candidate/all");
    const candidates: Party[] = response.data;
    return candidates;
  } catch (error) {
    return EmptyParty;
  } 
};
