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
 * WindGenTurbineType3aIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindGenTurbineType3aIEC related services in the case of a
 *       WindGenTurbineType3aIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindGenTurbineType3aIEC interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindGenTurbineType3aIEC
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindGenTurbineType3aIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindGenTurbineType3aIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindGenTurbineType3aIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindGenTurbineType3aIECBusinessDelegate
   */
  public static WindGenTurbineType3aIECBusinessDelegate getWindGenTurbineType3aIECInstance() {
    return (new WindGenTurbineType3aIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindGenTurbineType3aIEC(
      CreateWindGenTurbineType3aIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindGenTurbineType3aIECId() == null)
        command.setWindGenTurbineType3aIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindGenTurbineType3aIECCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindGenTurbineType3aIECCommand of WindGenTurbineType3aIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindGenTurbineType3aIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindGenTurbineType3aIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindGenTurbineType3aIEC(
      UpdateWindGenTurbineType3aIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindGenTurbineType3aIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindGenTurbineType3aIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindGenTurbineType3aIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindGenTurbineType3aIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindGenTurbineType3aIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindGenTurbineType3aIEC using Id = "
              + command.getWindGenTurbineType3aIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindGenTurbineType3aIEC via WindGenTurbineType3aIECFetchOneSummary
   *
   * @param summary WindGenTurbineType3aIECFetchOneSummary
   * @return WindGenTurbineType3aIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindGenTurbineType3aIEC getWindGenTurbineType3aIEC(
      WindGenTurbineType3aIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "WindGenTurbineType3aIECFetchOneSummary arg cannot be null");

    WindGenTurbineType3aIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindGenTurbineType3aIEC
      // --------------------------------------
      CompletableFuture<WindGenTurbineType3aIEC> futureEntity =
          queryGateway.query(
              new FindWindGenTurbineType3aIECQuery(
                  new LoadWindGenTurbineType3aIECFilter(summary.getWindGenTurbineType3aIECId())),
              ResponseTypes.instanceOf(WindGenTurbineType3aIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindGenTurbineType3aIEC with id "
              + summary.getWindGenTurbineType3aIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindGenTurbineType3aIECs
   *
   * @return List<WindGenTurbineType3aIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindGenTurbineType3aIEC> getAllWindGenTurbineType3aIEC() throws ProcessingException {
    List<WindGenTurbineType3aIEC> list = null;

    try {
      CompletableFuture<List<WindGenTurbineType3aIEC>> futureList =
          queryGateway.query(
              new FindAllWindGenTurbineType3aIECQuery(),
              ResponseTypes.multipleInstancesOf(WindGenTurbineType3aIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindGenTurbineType3aIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Kpc on WindGenTurbineType3aIEC
   *
   * @param command AssignKpcToWindGenTurbineType3aIECCommand
   * @exception ProcessingException
   */
  public void assignKpc(AssignKpcToWindGenTurbineType3aIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindGenTurbineType3aIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindGenTurbineType3aIECBusinessDelegate parentDelegate =
        WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(command);

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
   * unAssign Kpc on WindGenTurbineType3aIEC
   *
   * @param command UnAssignKpcFromWindGenTurbineType3aIECCommand
   * @exception ProcessingException
   */
  public void unAssignKpc(UnAssignKpcFromWindGenTurbineType3aIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpc on WindGenTurbineType3aIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tic on WindGenTurbineType3aIEC
   *
   * @param command AssignTicToWindGenTurbineType3aIECCommand
   * @exception ProcessingException
   */
  public void assignTic(AssignTicToWindGenTurbineType3aIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindGenTurbineType3aIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindGenTurbineType3aIECBusinessDelegate parentDelegate =
        WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(command);

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
   * unAssign Tic on WindGenTurbineType3aIEC
   *
   * @param command UnAssignTicFromWindGenTurbineType3aIECCommand
   * @exception ProcessingException
   */
  public void unAssignTic(UnAssignTicFromWindGenTurbineType3aIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tic on WindGenTurbineType3aIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xs on WindGenTurbineType3aIEC
   *
   * @param command AssignXsToWindGenTurbineType3aIECCommand
   * @exception ProcessingException
   */
  public void assignXs(AssignXsToWindGenTurbineType3aIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindGenTurbineType3aIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindGenTurbineType3aIECBusinessDelegate parentDelegate =
        WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(command);

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
   * unAssign Xs on WindGenTurbineType3aIEC
   *
   * @param command UnAssignXsFromWindGenTurbineType3aIECCommand
   * @exception ProcessingException
   */
  public void unAssignXs(UnAssignXsFromWindGenTurbineType3aIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType3aIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xs on WindGenTurbineType3aIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindGenTurbineType3aIEC
   */
  private WindGenTurbineType3aIEC load(UUID id) throws ProcessingException {
    windGenTurbineType3aIEC =
        WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
            .getWindGenTurbineType3aIEC(new WindGenTurbineType3aIECFetchOneSummary(id));
    return windGenTurbineType3aIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindGenTurbineType3aIEC windGenTurbineType3aIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3aIECBusinessDelegate.class.getName());
}
