import React, { Component } from 'react'
import EquivalentShuntService from '../services/EquivalentShuntService';

class UpdateEquivalentShuntComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEquivalentShunt = this.updateEquivalentShunt.bind(this);

    }

    componentDidMount(){
        EquivalentShuntService.getEquivalentShuntById(this.state.id).then( (res) =>{
            let equivalentShunt = res.data;
            this.setState({
            });
        });
    }

    updateEquivalentShunt = (e) => {
        e.preventDefault();
        let equivalentShunt = {
            equivalentShuntId: this.state.id,
        };
        console.log('equivalentShunt => ' + JSON.stringify(equivalentShunt));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquivalentShuntService.updateEquivalentShunt(equivalentShunt).then( res => {
            this.props.history.push('/equivalentShunts');
        });
    }


    cancel(){
        this.props.history.push('/equivalentShunts');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquivalentShunt</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquivalentShunt}>Save</button>
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

export default UpdateEquivalentShuntComponent
