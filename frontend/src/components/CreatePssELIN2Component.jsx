import React, { Component } from 'react'
import PssELIN2Service from '../services/PssELIN2Service';

class CreatePssELIN2Component extends Component {
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
            PssELIN2Service.getPssELIN2ById(this.state.id).then( (res) =>{
                let pssELIN2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePssELIN2 = (e) => {
        e.preventDefault();
        let pssELIN2 = {
                pssELIN2Id: this.state.id,
            };
        console.log('pssELIN2 => ' + JSON.stringify(pssELIN2));

        // step 5
        if(this.state.id === '_add'){
            pssELIN2.pssELIN2Id=''
            PssELIN2Service.createPssELIN2(pssELIN2).then(res =>{
                this.props.history.push('/pssELIN2s');
            });
        }else{
            PssELIN2Service.updatePssELIN2(pssELIN2).then( res => {
                this.props.history.push('/pssELIN2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pssELIN2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssELIN2</h3>
        }else{
            return <h3 className="text-center">Update PssELIN2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssELIN2}>Save</button>
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

export default CreatePssELIN2Component
