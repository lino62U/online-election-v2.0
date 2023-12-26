import React, { useState } from "react";
import { Register } from "./interfaces/register.interface";
import { useNavigate } from "react-router-dom";
import { registerPoliticalParty } from "./services/registerService";
import { GoToHome } from "../../components/GoToHome";

export const RegisterPage = () => {
    const [register, setRegister] = useState<Register>({
        idCandidate: 0, idPoliticalParty: 0, jobCandidate: "",
        lastNameCandidate: "", nameCandidate: "", namePoliticalParty: "", numVotes: 0
    });
    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setRegister({ ...register, [e.target.name]: e.target.value });
        setError(null);
    };

    const [error, setError] = useState<string | null>(null);

    const handleSubmit = async () => {
        if (!register.nameCandidate || !register.idCandidate) {
            setError("Todos los campos son obligatorios");
            return;
        }

        const registerError = await registerPoliticalParty(register);

        if (registerError) {
            setError(registerError);
        } else {

        }
    };
    return (
        <div className="flex justify-center items-center h-screen">
            <GoToHome />
            <div className="flex flex-col gap-5 bg-gray-800 p-10 rounded-2xl shadow-md shadow-slate-950">
                <div className="flex">
                    <h1 className="w-40">Id del Candidato:</h1>
                    <input
                        className="w-48 rounded-md py-1 text-black pl-2"
                        value={register.idCandidate}
                        onChange={handleChange}
                        name="idCandidate"
                    />
                </div>
                <div className="flex">
                    <h1 className="w-40">Id del partido politico:</h1>
                    <input
                        className="w-48 rounded-md py-1 text-black pl-2"
                        value={register.idPoliticalParty}
                        onChange={handleChange}
                        name="idPoliticalParty"
                    />
                </div>
                <div className="flex">
                    <h1 className="w-40">Cargo del candidato:</h1>
                    <input
                        className="w-48 rounded-md py-1 text-black pl-2"
                        value={register.jobCandidate}
                        onChange={handleChange}
                        name="jobCandidate"
                    />
                </div>
                <div className="flex">
                    <h1 className="w-40">Apellido del candidato:</h1>
                    <input
                        className="w-48 rounded-md py-1 text-black pl-2"
                        value={register.lastNameCandidate}
                        onChange={handleChange}
                        name="lastNameCandidate"
                    />
                </div>
                <div className="flex">
                    <h1 className="w-40">Nombre del candidato:</h1>
                    <input
                        className="w-48 rounded-md py-1 text-black pl-2"
                        value={register.nameCandidate}
                        onChange={handleChange}
                        name="nameCandidate"
                    />
                </div>
                <div className="flex">
                    <h1 className="w-40">Nombre del partido politico</h1>
                    <input
                        className="w-48 rounded-md py-1 text-black pl-2"
                        value={register.namePoliticalParty}
                        onChange={handleChange}
                        name="namePoliticalParty"
                    />
                </div>
                {error && <h1 className="text-red-500 font-light">{error}</h1>}
                <div>
                    <button
                        className="bg-blue-700 rounded-md hover:bg-sky-300 hover:text-black w-[22em] py-2"
                        onClick={handleSubmit}
                    >
                        Register
                    </button>
                </div>
            </div>
        </div>
    );
};
