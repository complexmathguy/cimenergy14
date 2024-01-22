import React, { Component } from 'react'
import ExcOEX3TService from '../services/ExcOEX3TService';

class CreateExcOEX3TComponent extends Component {
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
            ExcOEX3TService.getExcOEX3TById(this.state.id).then( (res) =>{
                let excOEX3T = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcOEX3T = (e) => {
        e.preventDefault();
        let excOEX3T = {
                excOEX3TId: this.state.id,
            };
        console.log('excOEX3T => ' + JSON.stringify(excOEX3T));

        // step 5
        if(this.state.id === '_add'){
            excOEX3T.excOEX3TId=''
            ExcOEX3TService.createExcOEX3T(excOEX3T).then(res =>{
                this.props.history.push('/excOEX3Ts');
            });
        }else{
            ExcOEX3TService.updateExcOEX3T(excOEX3T).then( res => {
                this.props.history.push('/excOEX3Ts');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excOEX3Ts');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcOEX3T</h3>
        }else{
            return <h3 className="text-center">Update ExcOEX3T</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcOEX3T}>Save</button>
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

export default CreateExcOEX3TComponent
