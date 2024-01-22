import React, { Component } from 'react'
import EquivalentShuntService from '../services/EquivalentShuntService';

class CreateEquivalentShuntComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            EquivalentShuntService.getEquivalentShuntById(this.state.id).then( (res) =>{
                let equivalentShunt = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEquivalentShunt = (e) => {
        e.preventDefault();
        let equivalentShunt = {
                equivalentShuntId: this.state.id,
            };
        console.log('equivalentShunt => ' + JSON.stringify(equivalentShunt));

        // step 5
        if(this.state.id === '_add'){
            equivalentShunt.equivalentShuntId=''
            EquivalentShuntService.createEquivalentShunt(equivalentShunt).then(res =>{
                this.props.history.push('/equivalentShunts');
            });
        }else{
            EquivalentShuntService.updateEquivalentShunt(equivalentShunt).then( res => {
                this.props.history.push('/equivalentShunts');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/equivalentShunts');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquivalentShunt</h3>
        }else{
            return <h3 className="text-center">Update EquivalentShunt</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquivalentShunt}>Save</button>
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

export default CreateEquivalentShuntComponent
