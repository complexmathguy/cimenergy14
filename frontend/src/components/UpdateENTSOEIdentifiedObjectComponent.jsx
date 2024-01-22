import React, { Component } from 'react'
import ENTSOEIdentifiedObjectService from '../services/ENTSOEIdentifiedObjectService';

class UpdateENTSOEIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateENTSOEIdentifiedObject = this.updateENTSOEIdentifiedObject.bind(this);

    }

    componentDidMount(){
        ENTSOEIdentifiedObjectService.getENTSOEIdentifiedObjectById(this.state.id).then( (res) =>{
            let eNTSOEIdentifiedObject = res.data;
            this.setState({
            });
        });
    }

    updateENTSOEIdentifiedObject = (e) => {
        e.preventDefault();
        let eNTSOEIdentifiedObject = {
            eNTSOEIdentifiedObjectId: this.state.id,
        };
        console.log('eNTSOEIdentifiedObject => ' + JSON.stringify(eNTSOEIdentifiedObject));
        console.log('id => ' + JSON.stringify(this.state.id));
        ENTSOEIdentifiedObjectService.updateENTSOEIdentifiedObject(eNTSOEIdentifiedObject).then( res => {
            this.props.history.push('/eNTSOEIdentifiedObjects');
        });
    }


    cancel(){
        this.props.history.push('/eNTSOEIdentifiedObjects');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ENTSOEIdentifiedObject</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateENTSOEIdentifiedObject}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateENTSOEIdentifiedObjectComponent
