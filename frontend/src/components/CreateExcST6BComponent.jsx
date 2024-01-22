import React, { Component } from 'react'
import ExcST6BService from '../services/ExcST6BService';

class CreateExcST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                oelin: ''
        }
        this.changeOelinHandler = this.changeOelinHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcST6BService.getExcST6BById(this.state.id).then( (res) =>{
                let excST6B = res.data;
                this.setState({
                    oelin: excST6B.oelin
                });
            });
        }        
    }
    saveOrUpdateExcST6B = (e) => {
        e.preventDefault();
        let excST6B = {
                excST6BId: this.state.id,
                oelin: this.state.oelin
            };
        console.log('excST6B => ' + JSON.stringify(excST6B));

        // step 5
        if(this.state.id === '_add'){
            excST6B.excST6BId=''
            ExcST6BService.createExcST6B(excST6B).then(res =>{
                this.props.history.push('/excST6Bs');
            });
        }else{
            ExcST6BService.updateExcST6B(excST6B).then( res => {
                this.props.history.push('/excST6Bs');
            });
        }
    }
    
    changeOelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excST6Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcST6B</h3>
        }else{
            return <h3 className="text-center">Update ExcST6B</h3>
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
                                            <label> Oelin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcST6B}>Save</button>
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

export default CreateExcST6BComponent
