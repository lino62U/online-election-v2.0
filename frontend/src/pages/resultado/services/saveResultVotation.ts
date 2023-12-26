import axios from "../../../config/axios";
import { ResultPartys } from "../interfaces/result.interface";
export const saveResultVotation = async (register: ResultPartys[]): Promise<string | null> => {
  try {
    const response = await axios.post("/api/parties/register",register);
    return null
  } catch (error) {
    return "Ocurrio un error";
  }
};
