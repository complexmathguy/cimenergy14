import React, { Component } from 'react'
import MechLoad1Service from '../services/MechLoad1Service';

class CreateMechLoad1Component extends Component {
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
            MechLoad1Service.getMechLoad1ById(this.state.id).then( (res) =>{
                let mechLoad1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateMechLoad1 = (e) => {
        e.preventDefault();
        let mechLoad1 = {
                mechLoad1Id: this.state.id,
            };
        console.log('mechLoad1 => ' + JSON.stringify(mechLoad1));

        // step 5
        if(this.state.id === '_add'){
            mechLoad1.mechLoad1Id=''
            MechLoad1Service.createMechLoad1(mechLoad1).then(res =>{
                this.props.history.push('/mechLoad1s');
            });
        }else{
            MechLoad1Service.updateMechLoad1(mechLoad1).then( res => {
                this.props.history.push('/mechLoad1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/mechLoad1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MechLoad1</h3>
        }else{
            return <h3 className="text-center">Update MechLoad1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMechLoad1}>Save</button>
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

export default CreateMechLoad1Component
