import React, { Component } from 'react'
import EquivalentInjectionService from '../services/EquivalentInjectionService';

class UpdateEquivalentInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEquivalentInjection = this.updateEquivalentInjection.bind(this);

    }

    componentDidMount(){
        EquivalentInjectionService.getEquivalentInjectionById(this.state.id).then( (res) =>{
            let equivalentInjection = res.data;
            this.setState({
            });
        });
    }

    updateEquivalentInjection = (e) => {
        e.preventDefault();
        let equivalentInjection = {
            equivalentInjectionId: this.state.id,
        };
        console.log('equivalentInjection => ' + JSON.stringify(equivalentInjection));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquivalentInjectionService.updateEquivalentInjection(equivalentInjection).then( res => {
            this.props.history.push('/equivalentInjections');
        });
    }


    cancel(){
        this.props.history.push('/equivalentInjections');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquivalentInjection</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquivalentInjection}>Save</button>
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

export default UpdateEquivalentInjectionComponent
