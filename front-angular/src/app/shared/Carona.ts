import { User } from './User';

export class Carona {
    id: number;
    cidadeOrigem: string;
    cidadeDestino: string;
    vagas: number;
    preco: number;
    data: Date;
    hora: string;
    status: number;
    usuario: User;
    descricao: string;
}