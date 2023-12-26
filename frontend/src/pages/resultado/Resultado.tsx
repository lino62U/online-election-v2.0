import { useEffect, useState } from "react";
import { fetchResultPartys } from "./services/fetchResultPartys";
import { ResultPartys } from "./interfaces/result.interface";
import { decodeToken } from "../../utils/decodeToken";
import { LogoutButton } from "../home/components/Logout";
import { saveResultVotation } from "./services/saveResultVotation";
import Modal from "../../components/Model";
import { useModal } from "../../hooks/useModal";
import { GrValidate } from "react-icons/gr";
import { MdErrorOutline } from "react-icons/md";

export const Resultado = () => {
    const { sub } = decodeToken();
    const [isOpenModal, openModal, closeModal] = useModal();
    const [error, setError] = useState<null | string>(null);
    const [resultPartys, setResultPartys] = useState<ResultPartys[]>([]);
    useEffect(() => {
        const fetchData = async () => {
            const fetchedCandidates = await fetchResultPartys();
            setResultPartys(fetchedCandidates);
        };
        fetchData();
    }, []);
    const findWinner = () => {
        if (resultPartys.length > 0) {
            return resultPartys.reduce((maxVotes, party) =>
                party.numVotes > maxVotes.numVotes ? party : maxVotes
            );
        } else {
            return null;
        }
    };
    const winner = findWinner();
    const handleSaveVotes = async () => {
        const saveVotes = await saveResultVotation(resultPartys);
        openModal();
        setError(saveVotes)
    }
    return (
        <div className="h-screen px-40 py-20">
            <div className="flex justify-between items-center bg-blue-800 rounded-md py-5 px-5">
                <div>Bienvenido {sub}</div>
                <div>
                    <LogoutButton />
                </div>
            </div>
            <div className="flex w-full justify-center py-10">
                <table className="w-[100em] border-[1px] border-gray-600">
                    <thead>
                        <tr className="[&>th]:py-3 [&>th]:bg-gray-500">
                            <th>ID Partido</th>
                            <th>Candidato</th>
                            <th>Cargo</th>
                            <th>Partico Politico</th>
                            <th>Logo</th>
                            <th>Nro Voto</th>
                        </tr>
                    </thead>
                    <tbody>
                        {resultPartys.map((party, index) => (<tr key={index} className=" bg-slate-700 [&>td]:text-center border-b-[1px] [&>td]:hover:bg-slate-600 border-gray-600">
                            <td className="w-24 text-center">{party.idPoliticalParty}</td>
                            <td>{party.nameCandidate} {party.lastNameCandidate}</td>
                            <td>{party.jobCandidate}</td>
                            <td>{party.namePoliticalParty}</td>
                            <td className="flex justify-center">
                                <img
                                    src={party.namePoliticalParty}
                                    alt="party"
                                    style={{ width: "80px", height: "80px" }}
                                />
                            </td>
                            <td>{party.numVotes}</td>
                        </tr>))}
                    </tbody>
                </table>
            </div>
            <div className="bg-violet-900 py-2 px-3">
                {winner && (
                    <div>
                        Actualmente el ganador es {winner.nameCandidate} {winner.lastNameCandidate} del partido {winner.namePoliticalParty} con {winner.numVotes} votos.
                    </div>
                )}
            </div>
            <div className="pt-3 justify-end w-full flex">
                <button className="p-2 bg-green-700" onClick={handleSaveVotes}>Guardar Resultados</button>
            </div>
            <Modal isOpen={isOpenModal} closeModal={closeModal} widthModal={25} heightModal={20}>
                <div className="p-5 flex flex-col justify-center items-center gap-3">
                    {error ? (
                        <>
                            <h2>{error}</h2>
                            <MdErrorOutline size={40} color="red" />
                        </>

                    ) : (
                        <>
                            <h2>Guardado Exitoso</h2>
                            <GrValidate size={40} color="green" />
                        </>
                    )}
                </div>
            </Modal>
        </div>
    )
}
