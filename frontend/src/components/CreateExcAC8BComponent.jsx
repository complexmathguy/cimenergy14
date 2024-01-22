import React, { Component } from 'react'
import ExcAC8BService from '../services/ExcAC8BService';

class CreateExcAC8BComponent extends Component {
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
            ExcAC8BService.getExcAC8BById(this.state.id).then( (res) =>{
                let excAC8B = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAC8B = (e) => {
        e.preventDefault();
        let excAC8B = {
                excAC8BId: this.state.id,
            };
        console.log('excAC8B => ' + JSON.stringify(excAC8B));

        // step 5
        if(this.state.id === '_add'){
            excAC8B.excAC8BId=''
            ExcAC8BService.createExcAC8B(excAC8B).then(res =>{
                this.props.history.push('/excAC8Bs');
            });
        }else{
            ExcAC8BService.updateExcAC8B(excAC8B).then( res => {
                this.props.history.push('/excAC8Bs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAC8Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC8B</h3>
        }else{
            return <h3 className="text-center">Update ExcAC8B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC8B}>Save</button>
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

export default CreateExcAC8BComponent
