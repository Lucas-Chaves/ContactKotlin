package business


import entity.ContactEntity
import repository.ContactRepository

class ContactBusiness {


    private fun validate(name: String, phone: String) {
        if (name == "") {
            throw Exception("Nome Obrigatório")
        }
        if (phone == "") {
            throw Exception("Telefone Obrigatório")
        }
    }


    private fun validateDelete(name: String, phone: String) {
        if (name == "" || phone == "") {
            throw Exception("É necessario selecionar um contato")
        }
    }

    fun getContactCountDescription(): String {
        val list = getList();
        return when {
            list.isEmpty() -> "0 Contatos"
            list.size == 1 -> "1 Contato"
            else -> "${list.size} Contatos"
        }


    }

    fun save(name: String, phone: String) {
        validate(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.save(contact)
    }

    fun delete(name: String, phone: String) {
        validateDelete(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.delete(contact)
    }

    fun getList(): List<ContactEntity> {
        return ContactRepository.getList();
    }

}