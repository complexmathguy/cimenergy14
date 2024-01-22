import React, { Component } from 'react'
import EquivalentInjectionService from '../services/EquivalentInjectionService';

class CreateEquivalentInjectionComponent extends Component {
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
            EquivalentInjectionService.getEquivalentInjectionById(this.state.id).then( (res) =>{
                let equivalentInjection = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEquivalentInjection = (e) => {
        e.preventDefault();
        let equivalentInjection = {
                equivalentInjectionId: this.state.id,
            };
        console.log('equivalentInjection => ' + JSON.stringify(equivalentInjection));

        // step 5
        if(this.state.id === '_add'){
            equivalentInjection.equivalentInjectionId=''
            EquivalentInjectionService.createEquivalentInjection(equivalentInjection).then(res =>{
                this.props.history.push('/equivalentInjections');
            });
        }else{
            EquivalentInjectionService.updateEquivalentInjection(equivalentInjection).then( res => {
                this.props.history.push('/equivalentInjections');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/equivalentInjections');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquivalentInjection</h3>
        }else{
            return <h3 className="text-center">Update EquivalentInjection</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquivalentInjection}>Save</button>
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

export default CreateEquivalentInjectionComponent
