import axiosConfig from "../../../config/axios";
import { Register } from "../interfaces/register.interface";

export const registerPoliticalParty = async (party : Register) : Promise<string | null>  => {
    try {
        const response = await axiosConfig.post("api/parties/register", party);
        return null;
      } catch (error) {
        return "Error en la solicitud de registrar party";
      }
}