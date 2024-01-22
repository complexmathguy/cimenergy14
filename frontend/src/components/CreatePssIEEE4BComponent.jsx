import React, { Component } from 'react'
import PssIEEE4BService from '../services/PssIEEE4BService';

class CreatePssIEEE4BComponent extends Component {
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
            PssIEEE4BService.getPssIEEE4BById(this.state.id).then( (res) =>{
                let pssIEEE4B = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePssIEEE4B = (e) => {
        e.preventDefault();
        let pssIEEE4B = {
                pssIEEE4BId: this.state.id,
            };
        console.log('pssIEEE4B => ' + JSON.stringify(pssIEEE4B));

        // step 5
        if(this.state.id === '_add'){
            pssIEEE4B.pssIEEE4BId=''
            PssIEEE4BService.createPssIEEE4B(pssIEEE4B).then(res =>{
                this.props.history.push('/pssIEEE4Bs');
            });
        }else{
            PssIEEE4BService.updatePssIEEE4B(pssIEEE4B).then( res => {
                this.props.history.push('/pssIEEE4Bs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pssIEEE4Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssIEEE4B</h3>
        }else{
            return <h3 className="text-center">Update PssIEEE4B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssIEEE4B}>Save</button>
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

export default CreatePssIEEE4BComponent
