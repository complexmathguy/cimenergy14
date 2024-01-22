import React, { Component } from 'react'
import ExcIEEEST7BService from '../services/ExcIEEEST7BService';

class CreateExcIEEEST7BComponent extends Component {
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
            ExcIEEEST7BService.getExcIEEEST7BById(this.state.id).then( (res) =>{
                let excIEEEST7B = res.data;
                this.setState({
                    oelin: excIEEEST7B.oelin,
                    uelin: excIEEEST7B.uelin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST7B = (e) => {
        e.preventDefault();
        let excIEEEST7B = {
                excIEEEST7BId: this.state.id,
                oelin: this.state.oelin,
                uelin: this.state.uelin
            };
        console.log('excIEEEST7B => ' + JSON.stringify(excIEEEST7B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST7B.excIEEEST7BId=''
            ExcIEEEST7BService.createExcIEEEST7B(excIEEEST7B).then(res =>{
                this.props.history.push('/excIEEEST7Bs');
            });
        }else{
            ExcIEEEST7BService.updateExcIEEEST7B(excIEEEST7B).then( res => {
                this.props.history.push('/excIEEEST7Bs');
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
        this.props.history.push('/excIEEEST7Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST7B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST7B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST7B}>Save</button>
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

export default CreateExcIEEEST7BComponent
