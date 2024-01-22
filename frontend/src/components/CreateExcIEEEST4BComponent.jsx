import React, { Component } from 'react'
import ExcIEEEST4BService from '../services/ExcIEEEST4BService';

class CreateExcIEEEST4BComponent extends Component {
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
            ExcIEEEST4BService.getExcIEEEST4BById(this.state.id).then( (res) =>{
                let excIEEEST4B = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST4B = (e) => {
        e.preventDefault();
        let excIEEEST4B = {
                excIEEEST4BId: this.state.id,
            };
        console.log('excIEEEST4B => ' + JSON.stringify(excIEEEST4B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST4B.excIEEEST4BId=''
            ExcIEEEST4BService.createExcIEEEST4B(excIEEEST4B).then(res =>{
                this.props.history.push('/excIEEEST4Bs');
            });
        }else{
            ExcIEEEST4BService.updateExcIEEEST4B(excIEEEST4B).then( res => {
                this.props.history.push('/excIEEEST4Bs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEST4Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST4B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST4B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST4B}>Save</button>
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

export default CreateExcIEEEST4BComponent
