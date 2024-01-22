import React, { Component } from 'react'
import ExcIEEEAC7BService from '../services/ExcIEEEAC7BService';

class CreateExcIEEEAC7BComponent extends Component {
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
            ExcIEEEAC7BService.getExcIEEEAC7BById(this.state.id).then( (res) =>{
                let excIEEEAC7B = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC7B = (e) => {
        e.preventDefault();
        let excIEEEAC7B = {
                excIEEEAC7BId: this.state.id,
            };
        console.log('excIEEEAC7B => ' + JSON.stringify(excIEEEAC7B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC7B.excIEEEAC7BId=''
            ExcIEEEAC7BService.createExcIEEEAC7B(excIEEEAC7B).then(res =>{
                this.props.history.push('/excIEEEAC7Bs');
            });
        }else{
            ExcIEEEAC7BService.updateExcIEEEAC7B(excIEEEAC7B).then( res => {
                this.props.history.push('/excIEEEAC7Bs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEAC7Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC7B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC7B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC7B}>Save</button>
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

export default CreateExcIEEEAC7BComponent
