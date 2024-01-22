/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcIEEEST1A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEST1A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEST1AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEST1A")
@Component("excIEEEST1A-projector")
public class ExcIEEEST1AProjector extends ExcIEEEST1AEntityProjector {

  // core constructor
  public ExcIEEEST1AProjector(
      ExcIEEEST1ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEST1AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEST1AEvent.class)
  public void handle(CreateExcIEEEST1AEvent event) {
    LOGGER.info("handling CreateExcIEEEST1AEvent - " + event);
    ExcIEEEST1A entity = new ExcIEEEST1A();
    entity.setExcIEEEST1AId(event.getExcIEEEST1AId());
    entity.setUelin(event.getUelin());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UpdateExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEST1AEvent.class)
  public void handle(UpdateExcIEEEST1AEvent event) {
    LOGGER.info("handling UpdateExcIEEEST1AEvent - " + event);

    ExcIEEEST1A entity = new ExcIEEEST1A();
    entity.setExcIEEEST1AId(event.getExcIEEEST1AId());
    entity.setIlr(event.getIlr());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKf(event.getKf());
    entity.setKlr(event.getKlr());
    entity.setPssin(event.getPssin());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTb1(event.getTb1());
    entity.setTc(event.getTc());
    entity.setTc1(event.getTc1());
    entity.setTf(event.getTf());
    entity.setUelin(event.getUelin());
    entity.setVamax(event.getVamax());
    entity.setVamin(event.getVamin());
    entity.setVimax(event.getVimax());
    entity.setVimin(event.getVimin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event DeleteExcIEEEST1AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEST1AEvent.class)
  public void handle(DeleteExcIEEEST1AEvent event) {
    LOGGER.info("handling DeleteExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEST1A entity = delete(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignIlrToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignIlrToExcIEEEST1AEvent.class)
  public void handle(AssignIlrToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignIlrToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignIlr(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignIlrFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignIlrFromExcIEEEST1AEvent.class)
  public void handle(UnAssignIlrFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignIlrFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignIlr(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEST1AEvent.class)
  public void handle(AssignKaToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignKa(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEST1AEvent.class)
  public void handle(UnAssignKaFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignKa(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEST1AEvent.class)
  public void handle(AssignKcToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignKc(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEST1AEvent.class)
  public void handle(UnAssignKcFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignKc(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignKfToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignKfToExcIEEEST1AEvent.class)
  public void handle(AssignKfToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignKfToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignKf(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcIEEEST1AEvent.class)
  public void handle(UnAssignKfFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignKf(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignKlrToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignKlrToExcIEEEST1AEvent.class)
  public void handle(AssignKlrToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignKlrToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignKlr(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignKlrFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignKlrFromExcIEEEST1AEvent.class)
  public void handle(UnAssignKlrFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignKlrFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignKlr(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignPssinToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignPssinToExcIEEEST1AEvent.class)
  public void handle(AssignPssinToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignPssinToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignPssin(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignPssinFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignPssinFromExcIEEEST1AEvent.class)
  public void handle(UnAssignPssinFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignPssinFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignPssin(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEST1AEvent.class)
  public void handle(AssignTaToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignTa(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEST1AEvent.class)
  public void handle(UnAssignTaFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignTa(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEST1AEvent.class)
  public void handle(AssignTbToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignTb(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEST1AEvent.class)
  public void handle(UnAssignTbFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignTb(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignTb1ToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignTb1ToExcIEEEST1AEvent.class)
  public void handle(AssignTb1ToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignTb1ToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignTb1(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignTb1FromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignTb1FromExcIEEEST1AEvent.class)
  public void handle(UnAssignTb1FromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignTb1FromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignTb1(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEST1AEvent.class)
  public void handle(AssignTcToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignTc(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEST1AEvent.class)
  public void handle(UnAssignTcFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignTc(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignTc1ToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignTc1ToExcIEEEST1AEvent.class)
  public void handle(AssignTc1ToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignTc1ToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignTc1(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignTc1FromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignTc1FromExcIEEEST1AEvent.class)
  public void handle(UnAssignTc1FromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignTc1FromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignTc1(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEST1AEvent.class)
  public void handle(AssignTfToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignTf(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEST1AEvent.class)
  public void handle(UnAssignTfFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignTf(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignVamaxToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcIEEEST1AEvent.class)
  public void handle(AssignVamaxToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignVamaxToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignVamax(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcIEEEST1AEvent.class)
  public void handle(UnAssignVamaxFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignVamax(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignVaminToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcIEEEST1AEvent.class)
  public void handle(AssignVaminToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignVaminToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignVamin(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcIEEEST1AEvent.class)
  public void handle(UnAssignVaminFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignVamin(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignVimaxToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignVimaxToExcIEEEST1AEvent.class)
  public void handle(AssignVimaxToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignVimaxToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignVimax(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignVimaxFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromExcIEEEST1AEvent.class)
  public void handle(UnAssignVimaxFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignVimaxFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignVimax(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignViminToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignViminToExcIEEEST1AEvent.class)
  public void handle(AssignViminToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignViminToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignVimin(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignViminFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignViminFromExcIEEEST1AEvent.class)
  public void handle(UnAssignViminFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignViminFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignVimin(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEST1AEvent.class)
  public void handle(AssignVrmaxToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignVrmax(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEST1AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignVrmax(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEST1AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEST1AEvent.class)
  public void handle(AssignVrminToExcIEEEST1AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST1A entity = assignVrmin(event.getExcIEEEST1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEST1AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEST1AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEST1AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEST1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST1A entity = unAssignVrmin(event.getExcIEEEST1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST1A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEST1A via an ExcIEEEST1APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEST1A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEST1A handle(FindExcIEEEST1AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEST1AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST1As
   *
   * @param query FindAllExcIEEEST1AQuery
   * @return List<ExcIEEEST1A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEST1A> handle(FindAllExcIEEEST1AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEST1A, but only if the id matches
   *
   * @param entity ExcIEEEST1A
   */
  protected void emitFindExcIEEEST1A(ExcIEEEST1A entity) {
    LOGGER.info("handling emitFindExcIEEEST1A");

    queryUpdateEmitter.emit(
        FindExcIEEEST1AQuery.class,
        query -> query.getFilter().getExcIEEEST1AId().equals(entity.getExcIEEEST1AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEST1A
   *
   * @param entity ExcIEEEST1A
   */
  protected void emitFindAllExcIEEEST1A(ExcIEEEST1A entity) {
    LOGGER.info("handling emitFindAllExcIEEEST1A");

    queryUpdateEmitter.emit(FindAllExcIEEEST1AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST1AProjector.class.getName());
}
