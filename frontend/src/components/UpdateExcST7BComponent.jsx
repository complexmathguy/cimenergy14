import React, { Component } from 'react'
import ExcST7BService from '../services/ExcST7BService';

class UpdateExcST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                oelin: '',
                uelin: ''
        }
        this.updateExcST7B = this.updateExcST7B.bind(this);

        this.changeOelinHandler = this.changeOelinHandler.bind(this);
        this.changeUelinHandler = this.changeUelinHandler.bind(this);
    }

    componentDidMount(){
        ExcST7BService.getExcST7BById(this.state.id).then( (res) =>{
            let excST7B = res.data;
            this.setState({
                oelin: excST7B.oelin,
                uelin: excST7B.uelin
            });
        });
    }

    updateExcST7B = (e) => {
        e.preventDefault();
        let excST7B = {
            excST7BId: this.state.id,
            oelin: this.state.oelin,
            uelin: this.state.uelin
        };
        console.log('excST7B => ' + JSON.stringify(excST7B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcST7BService.updateExcST7B(excST7B).then( res => {
            this.props.history.push('/excST7Bs');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcST7B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Oelin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Uelin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcST7B}>Save</button>
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

export default UpdateExcST7BComponent
