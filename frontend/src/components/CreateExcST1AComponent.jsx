import React, { Component } from 'react'
import ExcST1AService from '../services/ExcST1AService';

class CreateExcST1AComponent extends Component {
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
            ExcST1AService.getExcST1AById(this.state.id).then( (res) =>{
                let excST1A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcST1A = (e) => {
        e.preventDefault();
        let excST1A = {
                excST1AId: this.state.id,
            };
        console.log('excST1A => ' + JSON.stringify(excST1A));

        // step 5
        if(this.state.id === '_add'){
            excST1A.excST1AId=''
            ExcST1AService.createExcST1A(excST1A).then(res =>{
                this.props.history.push('/excST1As');
            });
        }else{
            ExcST1AService.updateExcST1A(excST1A).then( res => {
                this.props.history.push('/excST1As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excST1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcST1A</h3>
        }else{
            return <h3 className="text-center">Update ExcST1A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcST1A}>Save</button>
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

export default CreateExcST1AComponent
