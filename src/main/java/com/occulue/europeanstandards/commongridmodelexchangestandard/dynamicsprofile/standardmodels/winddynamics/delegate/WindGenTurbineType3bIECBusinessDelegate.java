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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * WindGenTurbineType3bIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindGenTurbineType3bIEC related services in the case of a
 *       WindGenTurbineType3bIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindGenTurbineType3bIEC interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindGenTurbineType3bIEC
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindGenTurbineType3bIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindGenTurbineType3bIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindGenTurbineType3bIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindGenTurbineType3bIECBusinessDelegate
   */
  public static WindGenTurbineType3bIECBusinessDelegate getWindGenTurbineType3bIECInstance() {
    return (new WindGenTurbineType3bIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindGenTurbineType3bIEC(
      CreateWindGenTurbineType3bIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindGenTurbineType3bIECId() == null)
        command.setWindGenTurbineType3bIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindGenTurbineType3bIECCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindGenTurbineType3bIECCommand of WindGenTurbineType3bIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindGenTurbineType3bIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindGenTurbineType3bIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindGenTurbineType3bIEC(
      UpdateWindGenTurbineType3bIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindGenTurbineType3bIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindGenTurbineType3bIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindGenTurbineType3bIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindGenTurbineType3bIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindGenTurbineType3bIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindGenTurbineType3bIEC using Id = "
              + command.getWindGenTurbineType3bIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindGenTurbineType3bIEC via WindGenTurbineType3bIECFetchOneSummary
   *
   * @param summary WindGenTurbineType3bIECFetchOneSummary
   * @return WindGenTurbineType3bIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindGenTurbineType3bIEC getWindGenTurbineType3bIEC(
      WindGenTurbineType3bIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "WindGenTurbineType3bIECFetchOneSummary arg cannot be null");

    WindGenTurbineType3bIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindGenTurbineType3bIEC
      // --------------------------------------
      CompletableFuture<WindGenTurbineType3bIEC> futureEntity =
          queryGateway.query(
              new FindWindGenTurbineType3bIECQuery(
                  new LoadWindGenTurbineType3bIECFilter(summary.getWindGenTurbineType3bIECId())),
              ResponseTypes.instanceOf(WindGenTurbineType3bIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindGenTurbineType3bIEC with id "
              + summary.getWindGenTurbineType3bIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindGenTurbineType3bIECs
   *
   * @return List<WindGenTurbineType3bIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindGenTurbineType3bIEC> getAllWindGenTurbineType3bIEC() throws ProcessingException {
    List<WindGenTurbineType3bIEC> list = null;

    try {
      CompletableFuture<List<WindGenTurbineType3bIEC>> futureList =
          queryGateway.query(
              new FindAllWindGenTurbineType3bIECQuery(),
              ResponseTypes.multipleInstancesOf(WindGenTurbineType3bIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindGenTurbineType3bIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Fducw on WindGenTurbineType3bIEC
   *
   * @param command AssignFducwToWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void assignFducw(AssignFducwToWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindGenTurbineType3bIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindGenTurbineType3bIECBusinessDelegate parentDelegate =
        WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Fducw on WindGenTurbineType3bIEC
   *
   * @param command UnAssignFducwFromWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void unAssignFducw(UnAssignFducwFromWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Fducw on WindGenTurbineType3bIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mwtcwp on WindGenTurbineType3bIEC
   *
   * @param command AssignMwtcwpToWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void assignMwtcwp(AssignMwtcwpToWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindGenTurbineType3bIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    WindGenTurbineType3bIECBusinessDelegate parentDelegate =
        WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Mwtcwp on WindGenTurbineType3bIEC
   *
   * @param command UnAssignMwtcwpFromWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void unAssignMwtcwp(UnAssignMwtcwpFromWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mwtcwp on WindGenTurbineType3bIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tg on WindGenTurbineType3bIEC
   *
   * @param command AssignTgToWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void assignTg(AssignTgToWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindGenTurbineType3bIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindGenTurbineType3bIECBusinessDelegate parentDelegate =
        WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tg on WindGenTurbineType3bIEC
   *
   * @param command UnAssignTgFromWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void unAssignTg(UnAssignTgFromWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tg on WindGenTurbineType3bIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Two on WindGenTurbineType3bIEC
   *
   * @param command AssignTwoToWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void assignTwo(AssignTwoToWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindGenTurbineType3bIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindGenTurbineType3bIECBusinessDelegate parentDelegate =
        WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Two on WindGenTurbineType3bIEC
   *
   * @param command UnAssignTwoFromWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void unAssignTwo(UnAssignTwoFromWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Two on WindGenTurbineType3bIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xs on WindGenTurbineType3bIEC
   *
   * @param command AssignXsToWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void assignXs(AssignXsToWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindGenTurbineType3bIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindGenTurbineType3bIECBusinessDelegate parentDelegate =
        WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Xs on WindGenTurbineType3bIEC
   *
   * @param command UnAssignXsFromWindGenTurbineType3bIECCommand
   * @exception ProcessingException
   */
  public void unAssignXs(UnAssignXsFromWindGenTurbineType3bIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xs on WindGenTurbineType3bIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindGenTurbineType3bIEC
   */
  private WindGenTurbineType3bIEC load(UUID id) throws ProcessingException {
    windGenTurbineType3bIEC =
        WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
            .getWindGenTurbineType3bIEC(new WindGenTurbineType3bIECFetchOneSummary(id));
    return windGenTurbineType3bIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindGenTurbineType3bIEC windGenTurbineType3bIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3bIECBusinessDelegate.class.getName());
}
