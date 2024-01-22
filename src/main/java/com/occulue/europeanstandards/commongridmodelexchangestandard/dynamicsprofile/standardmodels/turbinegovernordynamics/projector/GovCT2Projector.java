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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GovCT2 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovCT2 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovCT2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govCT2")
@Component("govCT2-projector")
public class GovCT2Projector extends GovCT2EntityProjector {

  // core constructor
  public GovCT2Projector(GovCT2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovCT2Event
   */
  @EventHandler(payloadType = CreateGovCT2Event.class)
  public void handle(CreateGovCT2Event event) {
    LOGGER.info("handling CreateGovCT2Event - " + event);
    GovCT2 entity = new GovCT2();
    entity.setGovCT2Id(event.getGovCT2Id());
    entity.setRselect(event.getRselect());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UpdateGovCT2Event
   */
  @EventHandler(payloadType = UpdateGovCT2Event.class)
  public void handle(UpdateGovCT2Event event) {
    LOGGER.info("handling UpdateGovCT2Event - " + event);

    GovCT2 entity = new GovCT2();
    entity.setGovCT2Id(event.getGovCT2Id());
    entity.setAset(event.getAset());
    entity.setDb(event.getDb());
    entity.setDm(event.getDm());
    entity.setFlim1(event.getFlim1());
    entity.setFlim10(event.getFlim10());
    entity.setFlim2(event.getFlim2());
    entity.setFlim3(event.getFlim3());
    entity.setFlim4(event.getFlim4());
    entity.setFlim5(event.getFlim5());
    entity.setFlim6(event.getFlim6());
    entity.setFlim7(event.getFlim7());
    entity.setFlim8(event.getFlim8());
    entity.setFlim9(event.getFlim9());
    entity.setKa(event.getKa());
    entity.setKdgov(event.getKdgov());
    entity.setKigov(event.getKigov());
    entity.setKiload(event.getKiload());
    entity.setKimw(event.getKimw());
    entity.setKpgov(event.getKpgov());
    entity.setKpload(event.getKpload());
    entity.setKturb(event.getKturb());
    entity.setLdref(event.getLdref());
    entity.setMaxerr(event.getMaxerr());
    entity.setMinerr(event.getMinerr());
    entity.setMwbase(event.getMwbase());
    entity.setPlim1(event.getPlim1());
    entity.setPlim10(event.getPlim10());
    entity.setPlim2(event.getPlim2());
    entity.setPlim3(event.getPlim3());
    entity.setPlim4(event.getPlim4());
    entity.setPlim5(event.getPlim5());
    entity.setPlim6(event.getPlim6());
    entity.setPlim7(event.getPlim7());
    entity.setPlim8(event.getPlim8());
    entity.setPlim9(event.getPlim9());
    entity.setPrate(event.getPrate());
    entity.setR(event.getR());
    entity.setRclose(event.getRclose());
    entity.setRdown(event.getRdown());
    entity.setRopen(event.getRopen());
    entity.setRselect(event.getRselect());
    entity.setRup(event.getRup());
    entity.setTa(event.getTa());
    entity.setTact(event.getTact());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTdgov(event.getTdgov());
    entity.setTeng(event.getTeng());
    entity.setTfload(event.getTfload());
    entity.setTpelec(event.getTpelec());
    entity.setTsa(event.getTsa());
    entity.setTsb(event.getTsb());
    entity.setVmax(event.getVmax());
    entity.setVmin(event.getVmin());
    entity.setWfnl(event.getWfnl());
    entity.setWfspd(event.getWfspd());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event DeleteGovCT2Event
   */
  @EventHandler(payloadType = DeleteGovCT2Event.class)
  public void handle(DeleteGovCT2Event event) {
    LOGGER.info("handling DeleteGovCT2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovCT2 entity = delete(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignAsetToGovCT2Event
   */
  @EventHandler(payloadType = AssignAsetToGovCT2Event.class)
  public void handle(AssignAsetToGovCT2Event event) {
    LOGGER.info("handling AssignAsetToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignAset(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignAsetFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignAsetFromGovCT2Event.class)
  public void handle(UnAssignAsetFromGovCT2Event event) {
    LOGGER.info("handling UnAssignAsetFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignAset(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignDbToGovCT2Event
   */
  @EventHandler(payloadType = AssignDbToGovCT2Event.class)
  public void handle(AssignDbToGovCT2Event event) {
    LOGGER.info("handling AssignDbToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignDb(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignDbFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignDbFromGovCT2Event.class)
  public void handle(UnAssignDbFromGovCT2Event event) {
    LOGGER.info("handling UnAssignDbFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignDb(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignDmToGovCT2Event
   */
  @EventHandler(payloadType = AssignDmToGovCT2Event.class)
  public void handle(AssignDmToGovCT2Event event) {
    LOGGER.info("handling AssignDmToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignDm(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignDmFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignDmFromGovCT2Event.class)
  public void handle(UnAssignDmFromGovCT2Event event) {
    LOGGER.info("handling UnAssignDmFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignDm(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim1ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim1ToGovCT2Event.class)
  public void handle(AssignFlim1ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim1ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim1(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim1FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim1FromGovCT2Event.class)
  public void handle(UnAssignFlim1FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim1FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim1(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim10ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim10ToGovCT2Event.class)
  public void handle(AssignFlim10ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim10ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim10(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim10FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim10FromGovCT2Event.class)
  public void handle(UnAssignFlim10FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim10FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim10(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim2ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim2ToGovCT2Event.class)
  public void handle(AssignFlim2ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim2ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim2(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim2FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim2FromGovCT2Event.class)
  public void handle(UnAssignFlim2FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim2FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim2(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim3ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim3ToGovCT2Event.class)
  public void handle(AssignFlim3ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim3ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim3(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim3FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim3FromGovCT2Event.class)
  public void handle(UnAssignFlim3FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim3FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim3(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim4ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim4ToGovCT2Event.class)
  public void handle(AssignFlim4ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim4ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim4(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim4FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim4FromGovCT2Event.class)
  public void handle(UnAssignFlim4FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim4FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim4(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim5ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim5ToGovCT2Event.class)
  public void handle(AssignFlim5ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim5ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim5(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim5FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim5FromGovCT2Event.class)
  public void handle(UnAssignFlim5FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim5FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim5(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim6ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim6ToGovCT2Event.class)
  public void handle(AssignFlim6ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim6ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim6(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim6FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim6FromGovCT2Event.class)
  public void handle(UnAssignFlim6FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim6FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim6(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim7ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim7ToGovCT2Event.class)
  public void handle(AssignFlim7ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim7ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim7(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim7FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim7FromGovCT2Event.class)
  public void handle(UnAssignFlim7FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim7FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim7(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim8ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim8ToGovCT2Event.class)
  public void handle(AssignFlim8ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim8ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim8(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim8FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim8FromGovCT2Event.class)
  public void handle(UnAssignFlim8FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim8FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim8(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignFlim9ToGovCT2Event
   */
  @EventHandler(payloadType = AssignFlim9ToGovCT2Event.class)
  public void handle(AssignFlim9ToGovCT2Event event) {
    LOGGER.info("handling AssignFlim9ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignFlim9(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignFlim9FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignFlim9FromGovCT2Event.class)
  public void handle(UnAssignFlim9FromGovCT2Event event) {
    LOGGER.info("handling UnAssignFlim9FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignFlim9(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignKaToGovCT2Event
   */
  @EventHandler(payloadType = AssignKaToGovCT2Event.class)
  public void handle(AssignKaToGovCT2Event event) {
    LOGGER.info("handling AssignKaToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignKa(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignKaFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignKaFromGovCT2Event.class)
  public void handle(UnAssignKaFromGovCT2Event event) {
    LOGGER.info("handling UnAssignKaFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignKa(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignKdgovToGovCT2Event
   */
  @EventHandler(payloadType = AssignKdgovToGovCT2Event.class)
  public void handle(AssignKdgovToGovCT2Event event) {
    LOGGER.info("handling AssignKdgovToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignKdgov(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignKdgovFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignKdgovFromGovCT2Event.class)
  public void handle(UnAssignKdgovFromGovCT2Event event) {
    LOGGER.info("handling UnAssignKdgovFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignKdgov(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignKigovToGovCT2Event
   */
  @EventHandler(payloadType = AssignKigovToGovCT2Event.class)
  public void handle(AssignKigovToGovCT2Event event) {
    LOGGER.info("handling AssignKigovToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignKigov(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignKigovFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignKigovFromGovCT2Event.class)
  public void handle(UnAssignKigovFromGovCT2Event event) {
    LOGGER.info("handling UnAssignKigovFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignKigov(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignKiloadToGovCT2Event
   */
  @EventHandler(payloadType = AssignKiloadToGovCT2Event.class)
  public void handle(AssignKiloadToGovCT2Event event) {
    LOGGER.info("handling AssignKiloadToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignKiload(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignKiloadFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignKiloadFromGovCT2Event.class)
  public void handle(UnAssignKiloadFromGovCT2Event event) {
    LOGGER.info("handling UnAssignKiloadFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignKiload(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignKimwToGovCT2Event
   */
  @EventHandler(payloadType = AssignKimwToGovCT2Event.class)
  public void handle(AssignKimwToGovCT2Event event) {
    LOGGER.info("handling AssignKimwToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignKimw(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignKimwFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignKimwFromGovCT2Event.class)
  public void handle(UnAssignKimwFromGovCT2Event event) {
    LOGGER.info("handling UnAssignKimwFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignKimw(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignKpgovToGovCT2Event
   */
  @EventHandler(payloadType = AssignKpgovToGovCT2Event.class)
  public void handle(AssignKpgovToGovCT2Event event) {
    LOGGER.info("handling AssignKpgovToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignKpgov(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignKpgovFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignKpgovFromGovCT2Event.class)
  public void handle(UnAssignKpgovFromGovCT2Event event) {
    LOGGER.info("handling UnAssignKpgovFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignKpgov(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignKploadToGovCT2Event
   */
  @EventHandler(payloadType = AssignKploadToGovCT2Event.class)
  public void handle(AssignKploadToGovCT2Event event) {
    LOGGER.info("handling AssignKploadToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignKpload(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignKploadFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignKploadFromGovCT2Event.class)
  public void handle(UnAssignKploadFromGovCT2Event event) {
    LOGGER.info("handling UnAssignKploadFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignKpload(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignKturbToGovCT2Event
   */
  @EventHandler(payloadType = AssignKturbToGovCT2Event.class)
  public void handle(AssignKturbToGovCT2Event event) {
    LOGGER.info("handling AssignKturbToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignKturb(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignKturbFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignKturbFromGovCT2Event.class)
  public void handle(UnAssignKturbFromGovCT2Event event) {
    LOGGER.info("handling UnAssignKturbFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignKturb(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignLdrefToGovCT2Event
   */
  @EventHandler(payloadType = AssignLdrefToGovCT2Event.class)
  public void handle(AssignLdrefToGovCT2Event event) {
    LOGGER.info("handling AssignLdrefToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignLdref(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignLdrefFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignLdrefFromGovCT2Event.class)
  public void handle(UnAssignLdrefFromGovCT2Event event) {
    LOGGER.info("handling UnAssignLdrefFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignLdref(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignMaxerrToGovCT2Event
   */
  @EventHandler(payloadType = AssignMaxerrToGovCT2Event.class)
  public void handle(AssignMaxerrToGovCT2Event event) {
    LOGGER.info("handling AssignMaxerrToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignMaxerr(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignMaxerrFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignMaxerrFromGovCT2Event.class)
  public void handle(UnAssignMaxerrFromGovCT2Event event) {
    LOGGER.info("handling UnAssignMaxerrFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignMaxerr(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignMinerrToGovCT2Event
   */
  @EventHandler(payloadType = AssignMinerrToGovCT2Event.class)
  public void handle(AssignMinerrToGovCT2Event event) {
    LOGGER.info("handling AssignMinerrToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignMinerr(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignMinerrFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignMinerrFromGovCT2Event.class)
  public void handle(UnAssignMinerrFromGovCT2Event event) {
    LOGGER.info("handling UnAssignMinerrFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignMinerr(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignMwbaseToGovCT2Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovCT2Event.class)
  public void handle(AssignMwbaseToGovCT2Event event) {
    LOGGER.info("handling AssignMwbaseToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignMwbase(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovCT2Event.class)
  public void handle(UnAssignMwbaseFromGovCT2Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignMwbase(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim1ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim1ToGovCT2Event.class)
  public void handle(AssignPlim1ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim1ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim1(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim1FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim1FromGovCT2Event.class)
  public void handle(UnAssignPlim1FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim1FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim1(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim10ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim10ToGovCT2Event.class)
  public void handle(AssignPlim10ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim10ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim10(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim10FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim10FromGovCT2Event.class)
  public void handle(UnAssignPlim10FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim10FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim10(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim2ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim2ToGovCT2Event.class)
  public void handle(AssignPlim2ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim2ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim2(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim2FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim2FromGovCT2Event.class)
  public void handle(UnAssignPlim2FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim2FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim2(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim3ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim3ToGovCT2Event.class)
  public void handle(AssignPlim3ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim3ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim3(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim3FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim3FromGovCT2Event.class)
  public void handle(UnAssignPlim3FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim3FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim3(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim4ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim4ToGovCT2Event.class)
  public void handle(AssignPlim4ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim4ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim4(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim4FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim4FromGovCT2Event.class)
  public void handle(UnAssignPlim4FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim4FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim4(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim5ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim5ToGovCT2Event.class)
  public void handle(AssignPlim5ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim5ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim5(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim5FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim5FromGovCT2Event.class)
  public void handle(UnAssignPlim5FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim5FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim5(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim6ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim6ToGovCT2Event.class)
  public void handle(AssignPlim6ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim6ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim6(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim6FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim6FromGovCT2Event.class)
  public void handle(UnAssignPlim6FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim6FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim6(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim7ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim7ToGovCT2Event.class)
  public void handle(AssignPlim7ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim7ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim7(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim7FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim7FromGovCT2Event.class)
  public void handle(UnAssignPlim7FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim7FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim7(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim8ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim8ToGovCT2Event.class)
  public void handle(AssignPlim8ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim8ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim8(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim8FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim8FromGovCT2Event.class)
  public void handle(UnAssignPlim8FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim8FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim8(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPlim9ToGovCT2Event
   */
  @EventHandler(payloadType = AssignPlim9ToGovCT2Event.class)
  public void handle(AssignPlim9ToGovCT2Event event) {
    LOGGER.info("handling AssignPlim9ToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPlim9(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPlim9FromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPlim9FromGovCT2Event.class)
  public void handle(UnAssignPlim9FromGovCT2Event event) {
    LOGGER.info("handling UnAssignPlim9FromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPlim9(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignPrateToGovCT2Event
   */
  @EventHandler(payloadType = AssignPrateToGovCT2Event.class)
  public void handle(AssignPrateToGovCT2Event event) {
    LOGGER.info("handling AssignPrateToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignPrate(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignPrateFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignPrateFromGovCT2Event.class)
  public void handle(UnAssignPrateFromGovCT2Event event) {
    LOGGER.info("handling UnAssignPrateFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignPrate(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignRToGovCT2Event
   */
  @EventHandler(payloadType = AssignRToGovCT2Event.class)
  public void handle(AssignRToGovCT2Event event) {
    LOGGER.info("handling AssignRToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignR(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignRFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignRFromGovCT2Event.class)
  public void handle(UnAssignRFromGovCT2Event event) {
    LOGGER.info("handling UnAssignRFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignR(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignRcloseToGovCT2Event
   */
  @EventHandler(payloadType = AssignRcloseToGovCT2Event.class)
  public void handle(AssignRcloseToGovCT2Event event) {
    LOGGER.info("handling AssignRcloseToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignRclose(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignRcloseFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignRcloseFromGovCT2Event.class)
  public void handle(UnAssignRcloseFromGovCT2Event event) {
    LOGGER.info("handling UnAssignRcloseFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignRclose(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignRdownToGovCT2Event
   */
  @EventHandler(payloadType = AssignRdownToGovCT2Event.class)
  public void handle(AssignRdownToGovCT2Event event) {
    LOGGER.info("handling AssignRdownToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignRdown(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignRdownFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignRdownFromGovCT2Event.class)
  public void handle(UnAssignRdownFromGovCT2Event event) {
    LOGGER.info("handling UnAssignRdownFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignRdown(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignRopenToGovCT2Event
   */
  @EventHandler(payloadType = AssignRopenToGovCT2Event.class)
  public void handle(AssignRopenToGovCT2Event event) {
    LOGGER.info("handling AssignRopenToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignRopen(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignRopenFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignRopenFromGovCT2Event.class)
  public void handle(UnAssignRopenFromGovCT2Event event) {
    LOGGER.info("handling UnAssignRopenFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignRopen(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignRupToGovCT2Event
   */
  @EventHandler(payloadType = AssignRupToGovCT2Event.class)
  public void handle(AssignRupToGovCT2Event event) {
    LOGGER.info("handling AssignRupToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignRup(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignRupFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignRupFromGovCT2Event.class)
  public void handle(UnAssignRupFromGovCT2Event event) {
    LOGGER.info("handling UnAssignRupFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignRup(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTaToGovCT2Event
   */
  @EventHandler(payloadType = AssignTaToGovCT2Event.class)
  public void handle(AssignTaToGovCT2Event event) {
    LOGGER.info("handling AssignTaToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTa(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTaFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTaFromGovCT2Event.class)
  public void handle(UnAssignTaFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTaFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTa(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTactToGovCT2Event
   */
  @EventHandler(payloadType = AssignTactToGovCT2Event.class)
  public void handle(AssignTactToGovCT2Event event) {
    LOGGER.info("handling AssignTactToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTact(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTactFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTactFromGovCT2Event.class)
  public void handle(UnAssignTactFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTactFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTact(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTbToGovCT2Event
   */
  @EventHandler(payloadType = AssignTbToGovCT2Event.class)
  public void handle(AssignTbToGovCT2Event event) {
    LOGGER.info("handling AssignTbToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTb(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTbFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTbFromGovCT2Event.class)
  public void handle(UnAssignTbFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTbFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTb(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTcToGovCT2Event
   */
  @EventHandler(payloadType = AssignTcToGovCT2Event.class)
  public void handle(AssignTcToGovCT2Event event) {
    LOGGER.info("handling AssignTcToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTc(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTcFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTcFromGovCT2Event.class)
  public void handle(UnAssignTcFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTcFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTc(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTdgovToGovCT2Event
   */
  @EventHandler(payloadType = AssignTdgovToGovCT2Event.class)
  public void handle(AssignTdgovToGovCT2Event event) {
    LOGGER.info("handling AssignTdgovToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTdgov(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTdgovFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTdgovFromGovCT2Event.class)
  public void handle(UnAssignTdgovFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTdgovFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTdgov(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTengToGovCT2Event
   */
  @EventHandler(payloadType = AssignTengToGovCT2Event.class)
  public void handle(AssignTengToGovCT2Event event) {
    LOGGER.info("handling AssignTengToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTeng(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTengFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTengFromGovCT2Event.class)
  public void handle(UnAssignTengFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTengFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTeng(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTfloadToGovCT2Event
   */
  @EventHandler(payloadType = AssignTfloadToGovCT2Event.class)
  public void handle(AssignTfloadToGovCT2Event event) {
    LOGGER.info("handling AssignTfloadToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTfload(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTfloadFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTfloadFromGovCT2Event.class)
  public void handle(UnAssignTfloadFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTfloadFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTfload(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTpelecToGovCT2Event
   */
  @EventHandler(payloadType = AssignTpelecToGovCT2Event.class)
  public void handle(AssignTpelecToGovCT2Event event) {
    LOGGER.info("handling AssignTpelecToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTpelec(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTpelecFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTpelecFromGovCT2Event.class)
  public void handle(UnAssignTpelecFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTpelecFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTpelec(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTsaToGovCT2Event
   */
  @EventHandler(payloadType = AssignTsaToGovCT2Event.class)
  public void handle(AssignTsaToGovCT2Event event) {
    LOGGER.info("handling AssignTsaToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTsa(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTsaFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTsaFromGovCT2Event.class)
  public void handle(UnAssignTsaFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTsaFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTsa(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignTsbToGovCT2Event
   */
  @EventHandler(payloadType = AssignTsbToGovCT2Event.class)
  public void handle(AssignTsbToGovCT2Event event) {
    LOGGER.info("handling AssignTsbToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignTsb(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignTsbFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignTsbFromGovCT2Event.class)
  public void handle(UnAssignTsbFromGovCT2Event event) {
    LOGGER.info("handling UnAssignTsbFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignTsb(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignVmaxToGovCT2Event
   */
  @EventHandler(payloadType = AssignVmaxToGovCT2Event.class)
  public void handle(AssignVmaxToGovCT2Event event) {
    LOGGER.info("handling AssignVmaxToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignVmax(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignVmaxFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignVmaxFromGovCT2Event.class)
  public void handle(UnAssignVmaxFromGovCT2Event event) {
    LOGGER.info("handling UnAssignVmaxFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignVmax(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignVminToGovCT2Event
   */
  @EventHandler(payloadType = AssignVminToGovCT2Event.class)
  public void handle(AssignVminToGovCT2Event event) {
    LOGGER.info("handling AssignVminToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignVmin(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignVminFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignVminFromGovCT2Event.class)
  public void handle(UnAssignVminFromGovCT2Event event) {
    LOGGER.info("handling UnAssignVminFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignVmin(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignWfnlToGovCT2Event
   */
  @EventHandler(payloadType = AssignWfnlToGovCT2Event.class)
  public void handle(AssignWfnlToGovCT2Event event) {
    LOGGER.info("handling AssignWfnlToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignWfnl(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignWfnlFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignWfnlFromGovCT2Event.class)
  public void handle(UnAssignWfnlFromGovCT2Event event) {
    LOGGER.info("handling UnAssignWfnlFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignWfnl(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event AssignWfspdToGovCT2Event
   */
  @EventHandler(payloadType = AssignWfspdToGovCT2Event.class)
  public void handle(AssignWfspdToGovCT2Event event) {
    LOGGER.info("handling AssignWfspdToGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT2 entity = assignWfspd(event.getGovCT2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /*
   * @param	event UnAssignWfspdFromGovCT2Event
   */
  @EventHandler(payloadType = UnAssignWfspdFromGovCT2Event.class)
  public void handle(UnAssignWfspdFromGovCT2Event event) {
    LOGGER.info("handling UnAssignWfspdFromGovCT2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT2 entity = unAssignWfspd(event.getGovCT2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT2(entity);
  }

  /**
   * Method to retrieve the GovCT2 via an GovCT2PrimaryKey.
   *
   * @param id Long
   * @return GovCT2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovCT2 handle(FindGovCT2Query query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovCT2Id());
  }

  /**
   * Method to retrieve a collection of all GovCT2s
   *
   * @param query FindAllGovCT2Query
   * @return List<GovCT2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovCT2> handle(FindAllGovCT2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovCT2, but only if the id matches
   *
   * @param entity GovCT2
   */
  protected void emitFindGovCT2(GovCT2 entity) {
    LOGGER.info("handling emitFindGovCT2");

    queryUpdateEmitter.emit(
        FindGovCT2Query.class,
        query -> query.getFilter().getGovCT2Id().equals(entity.getGovCT2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovCT2
   *
   * @param entity GovCT2
   */
  protected void emitFindAllGovCT2(GovCT2 entity) {
    LOGGER.info("handling emitFindAllGovCT2");

    queryUpdateEmitter.emit(FindAllGovCT2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovCT2Projector.class.getName());
}
