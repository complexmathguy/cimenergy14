import React, { Component } from 'react'
import ExcST7BService from '../services/ExcST7BService';

class CreateExcST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                oelin: '',
                uelin: ''
        }
        this.changeOelinHandler = this.changeOelinHandler.bind(this);
        this.changeUelinHandler = this.changeUelinHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcST7BService.getExcST7BById(this.state.id).then( (res) =>{
                let excST7B = res.data;
                this.setState({
                    oelin: excST7B.oelin,
                    uelin: excST7B.uelin
                });
            });
        }        
    }
    saveOrUpdateExcST7B = (e) => {
        e.preventDefault();
        let excST7B = {
                excST7BId: this.state.id,
                oelin: this.state.oelin,
                uelin: this.state.uelin
            };
        console.log('excST7B => ' + JSON.stringify(excST7B));

        // step 5
        if(this.state.id === '_add'){
            excST7B.excST7BId=''
            ExcST7BService.createExcST7B(excST7B).then(res =>{
                this.props.history.push('/excST7Bs');
            });
        }else{
            ExcST7BService.updateExcST7B(excST7B).then( res => {
                this.props.history.push('/excST7Bs');
            });
        }
    }
    
    changeOelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }
    changeUelinHandler= (event) => {
        this.setState({uelin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excST7Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcST7B</h3>
        }else{
            return <h3 className="text-center">Update ExcST7B</h3>
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
                                            <label> Uelin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcST7B}>Save</button>
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

export default CreateExcST7BComponent
